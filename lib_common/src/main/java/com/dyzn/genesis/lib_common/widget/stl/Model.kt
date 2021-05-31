package com.dyzn.genesis.lib_common.widget.stl

import java.nio.FloatBuffer

/**
 *@author YLC-D
 *@create on 2021/1/18 10
 *说明:用于解析 STL 文件 记录STL 文件的 顶点 三角面 等信息
 */
class Model {
    /**
     * 以下分别保存所有点在x,y,z方向上的最大值、最小值
     */
    var xMax = 0f
    var xMin = 0f
    var yMax = 0f
    var yMin = 0f
    var zMax = 0f
    var zMin = 0f

    /**
     * 三角面个数
     */
    var facetCount = 0

    /**
     * 每个三角面的属性信息
     */
    var remarks: ShortArray? = null

    /**
     * 顶点数组转换而来的Buffer
     */
    var vertexBuffer: FloatBuffer? = null

    /**
     * 每个顶点对应的法向量转换而来的Buffer
     */
    var norVectorBuffer: FloatBuffer? = null

    /**
     * 返回模型的中心点
     */
    fun getCentrePoint(): Point {
        val cx = -(xMax + xMin) / 2
        val cy = -(yMax + yMin) / 2
        val cz = -zMin
        return Point(cx, cy, cz)
    }

    /**
     * 包裹模型的最大半径
     */
    fun getRadius(): Float {
        val dx = xMax - xMin
        val dy = yMax - yMin
        val dz = zMax - zMin
        return if (dx > dy && dx > dz) dx else if (dy > dz) dy else dz
    }

    fun setVertexBuffer(vertex: FloatArray) {
        vertexBuffer = StlUtil.floatToBuffer(vertex)
    }

    fun setNorVectorBuffer(norVector: FloatArray) {
        norVectorBuffer = StlUtil.floatToBuffer(norVector)
    }
}