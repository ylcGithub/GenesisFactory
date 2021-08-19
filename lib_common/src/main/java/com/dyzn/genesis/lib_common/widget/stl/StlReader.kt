package com.dyzn.genesis.lib_common.widget.stl

import java.io.File
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStream
import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlin.math.min

/**
 * @author YLC-D
 * stl文件的读取类
 */
class StlReader(private val loadListener: StlLoadListener) {
    @Throws(IOException::class)
    fun parserBinStlInSdCard(path: String): Model {
        val file = File(path)
        val fis = FileInputStream(file)
        return parserBinStl(fis)
    }

    /**
     * 解析二进制的Stl文件
     */
    @Throws(IOException::class)
    fun parserBinStl(inputStream: InputStream): Model {
        loadListener.onStart()
        val model = Model()
        //前面80字节是文件头，用于存贮文件名；
        inputStream.skip(80)

        //紧接着用 4 个字节的整数来描述模型的三角面片个数
        val bytes = ByteArray(4)
        // 读取三角面片个数
        inputStream.read(bytes)
        val facetCount: Int = StlUtil.byte4ToInt(bytes, 0)
        model.facetCount = facetCount
        if (facetCount == 0) {
            inputStream.close()
            loadListener.onFailure(Exception("model is null"))
            return model
        }

        // 每个三角面片占用固定的50个字节
        val facetBytes = ByteArray(50 * facetCount)
        // 将所有的三角面片读取到字节数组
        inputStream.read(facetBytes)
        //数据读取完毕后，可以把输入流关闭
        inputStream.close()
        parseModel(model, facetBytes)
        loadListener.onFinished()
        return model
    }

    /**
     * 解析模型数据，包括顶点数据、法向量数据、所占空间范围等
     */
    private fun parseModel(model: Model, facetBytes: ByteArray) {
        val facetCount = model.facetCount

        /**
         * 每个三角面片占用固定的50个字节,50字节当中：
         * 三角片的法向量：（1个向量相当于一个点）*（3维/点）*（4字节浮点数/维）=12字节
         * 三角片的三个点坐标：（3个点）*（3维/点）*（4字节浮点数/维）=36字节
         * 最后2个字节用来描述三角面片的属性信息
         */
        // 保存所有顶点坐标信息,一个三角形3个顶点，一个顶点3个坐标轴
        val verts = FloatArray(facetCount * 3 * 3)
        // 保存所有三角面对应的法向量位置，
        // 一个三角面对应一个法向量，一个法向量有3个点
        // 而绘制模型时，是针对需要每个顶点对应的法向量，因此存储长度需要*3
        // 又同一个三角面的三个顶点的法向量是相同的，
        // 因此后面写入法向量数据的时候，只需连续写入3个相同的法向量即可
        val vnorms = FloatArray(facetCount * 3 * 3)
        //保存所有三角面的属性信息
        val remarks = ShortArray(facetCount)
        var stlOffset = 0
        try {
            for (i in 0 until facetCount) {
                TimeUnit.MICROSECONDS.sleep(2)
                loadListener.onLoading(i, facetCount)
                for (j in 0..3) {
                    val x: Float = StlUtil.byte4ToFloat(facetBytes, stlOffset)
                    val y: Float = StlUtil.byte4ToFloat(facetBytes, stlOffset + 4)
                    val z: Float = StlUtil.byte4ToFloat(facetBytes, stlOffset + 8)
                    stlOffset += 12
                    if (j == 0) {
                        //法向量
                        vnorms[i * 9] = x
                        vnorms[i * 9 + 1] = y
                        vnorms[i * 9 + 2] = z
                        vnorms[i * 9 + 3] = x
                        vnorms[i * 9 + 4] = y
                        vnorms[i * 9 + 5] = z
                        vnorms[i * 9 + 6] = x
                        vnorms[i * 9 + 7] = y
                        vnorms[i * 9 + 8] = z
                    } else { //三个顶点
                        verts[i * 9 + (j - 1) * 3] = x
                        verts[i * 9 + (j - 1) * 3 + 1] = y
                        verts[i * 9 + (j - 1) * 3 + 2] = z

                        //记录模型中三个坐标轴方向的最大最小值
                        if (i == 0 && j == 1) {
                            model.xMax = x
                            model.xMin = model.xMax
                            model.yMax = y
                            model.yMin = model.yMax
                            model.zMax = z
                            model.zMin = model.zMax
                        } else {
                            model.xMin = min(model.xMin, x)
                            model.yMin = min(model.yMin, y)
                            model.zMin = min(model.zMin, z)
                            model.xMax = max(model.xMax, x)
                            model.yMax = max(model.yMax, y)
                            model.zMax = max(model.zMax, z)
                        }
                    }
                }
                val r: Short = StlUtil.byte2ToShort(facetBytes, stlOffset)
                stlOffset += 2
                remarks[i] = r
            }
        } catch (e: Exception) {
            e.printStackTrace()
            loadListener.onFailure(e)
        }
        //将读取的数据设置到Model对象中
        model.setVertexBuffer(verts)
        model.setNorVectorBuffer(vnorms)
        model.remarks = remarks
    }

    interface StlLoadListener {
        /**
         * 开始解析
         */
        fun onStart()

        /**
         * 正在解析
         *
         * @param cur   当前解析到第几个
         * @param total 模型含有的model总数
         */
        fun onLoading(cur: Int, total: Int)

        /**
         * 解析完成
         */
        fun onFinished()

        /**
         * 解析失败
         *
         * @param e 失败原因
         */
        fun onFailure(e: Exception)
    }
}