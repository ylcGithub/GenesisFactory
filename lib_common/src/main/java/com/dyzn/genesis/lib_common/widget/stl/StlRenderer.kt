package com.dyzn.genesis.lib_common.widget.stl

import android.opengl.GLSurfaceView
import android.opengl.GLU
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * @author YLC-D
 * STLObject渲染器
 */
class StlRenderer : GLSurfaceView.Renderer {
    var xAngle = 0f
    private var yAngle = 0f
    var zAngle = 0f
    private var xPosition = 0f
    private var yPosition = 0f
    private var zPosition = 0f

    /** 外部控制  */
    var scale = 1.0f
    private var scaleObject = 1.0f

    /** 当前展示  */
    private var currentScale = 1.0f
    private var objectScale = 1.0f

    /**
     * 当前固定
     * 模型初始化时占屏幕宽的比例
     */
    private var scaleNow = 1.0f
    private var scaleObjectNow = 1.0f
    private var zTranslation = 0f
    private var yTranslation = 0f
    private var model: Model? = null

    /**
     * 简单重绘（适用于旋转等）
     */
    fun requestRedraw() {
        bufferCounter = FRAME_BUFFER_COUNT
    }

    /**
     * 更换STLObject并重新渲染
     */
    fun requestRedraw(stlObject: Model?) {
        this.model = stlObject
        bufferCounter = FRAME_BUFFER_COUNT
        stlObject?.let { setPreviewParams() }
    }

    /**
     * 还原模型成最初的渲染位置大小
     */
    fun reduction() {
        scale = 1.0f
        scaleNow = 1.0f
        bufferCounter = FRAME_BUFFER_COUNT
        model?.let { setPreviewParams() }
    }

    /**
     * 调整预览设置,使模型展示时大小位置适中
     */
    private fun setPreviewParams() {
        val distanceY = model!!.yMax - model!!.yMin
        val distanceZ = model!!.zMax - model!!.zMin
        zTranslation = distanceZ * -3f
        yTranslation = distanceY / -5f
        xAngle = -90f
        yAngle = 0f
        zAngle = 0f

        //将模型置于中央位置
        val centrePoint = model!!.getCentrePoint()
        xPosition = centrePoint.x *objectScale
        yPosition = centrePoint.y *objectScale
        zPosition = centrePoint.z *objectScale
    }

    /**
     * 固定缩放比例
     */
    fun setScale() {
        scaleObjectNow = objectScale
        objectScale = 1.0f
        scaleObject = 1.0f
        scaleNow = currentScale
        currentScale = 1.0f
        scale = 1.0f
    }


    /**
     * 创建时调用
     */
    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
        //用指定颜色清空颜色缓存(模型周围的颜色)
        gl.glClearColor(0.95f, 0.95f, 0.95f, 1.0f)
        //设置渲染质量与速度的平衡
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST)
        //启动色彩混合
        gl.glEnable(GL10.GL_BLEND)
        //设置源因子和目标因子（源颜色乘以的系数称为“源因子”，目标颜色乘以的系数称为“目标因子”）
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA)
        //开启更新深度缓冲区
        gl.glEnable(GL10.GL_DEPTH_TEST)
        //指定深度缓冲比较值，GL10.GL_LEQUAL：输入的深度值小于或等于参考值，则通过
        gl.glDepthFunc(GL10.GL_LEQUAL)
        gl.glHint(3152, 4354)
        //法线在转换后被标准化
        gl.glEnable(GL10.GL_NORMALIZE)
        //设置两点间其他点颜色的过渡模式
        gl.glShadeModel(GL10.GL_SMOOTH)

        //开始对投影矩阵操作
        gl.glMatrixMode(GL10.GL_PROJECTION)
        openLight(gl)
        enableMaterial(gl)
    }

    //设置光源
    private fun openLight(gl: GL10) {
        // 打开光源
        gl.glEnable(GL10.GL_LIGHTING)
        //使用GL_LIGHT0光源
        gl.glEnable(GL10.GL_LIGHT0)
        //设置环境光
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_AMBIENT, lightAB)
        //设置漫射光
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_DIFFUSE, lightDB)
        //设置镜面反射光
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPECULAR, lightSB)
        //设置光源的位置
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_POSITION, lightPB)
    }

    //设置材料属性
    private fun enableMaterial(gl: GL10) {
        //使用颜色材质
        gl.glEnable(GL10.GL_COLOR_MATERIAL)
        //设置材质环境颜色
        gl.glMaterialfv(GL10.GL_FRONT, GL10.GL_AMBIENT, materialAB)
        //设置材质散射颜色
        gl.glMaterialfv(GL10.GL_FRONT, GL10.GL_DIFFUSE, materialDB)
        //设置材质镜面反射颜色
        gl.glMaterialfv(GL10.GL_FRONT, GL10.GL_SPECULAR, materialSB)
    }

    /**
     * 尺寸发生变化时调用
     */
    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        val aspectRatio = width.toFloat() / height
        //设置视口矩形的位置，宽度和高度
        gl.glViewport(0, 0, width, height)
        //重置当前矩阵
        gl.glLoadIdentity()
        //清空颜色缓存
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)
        //指定观察的视景体在世界坐标系中的具体大小
        GLU.gluPerspective(gl, 45f, aspectRatio, 1f, 5000f)
        //开始对模型视景的操作
        gl.glMatrixMode(GL10.GL_MODELVIEW)
        //定义视点矩阵（视点位置和参考点位置）
        val shotHeight = -3f
        GLU.gluLookAt(gl, 0f, 0f, shotHeight, 0f, 0f, 0f, 0f, 0f, 1f)
    }

    /**
     * 绘制每一帧的时候调用
     */
    override fun onDrawFrame(gl: GL10) {
        if (bufferCounter < 1) {
            return
        }
        bufferCounter--
        // 重置观察模型
        gl.glLoadIdentity()
        // 清除深度缓存和颜色
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT or GL10.GL_DEPTH_BUFFER_BIT)

        // 设置旋转和偏移
        gl.glTranslatef(0f, yTranslation, 0f)
        gl.glTranslatef(0f, 0f, zTranslation)
        gl.glRotatef(xAngle, 1f, 0f, 0f)
        gl.glRotatef(yAngle, 0f, 1f, 0f)
        gl.glRotatef(zAngle, 0f, 0f, 1f)
        //设置缩放
        currentScale = scaleNow * scale
        gl.glScalef(currentScale, currentScale, currentScale)

        //使能顶点数组功能
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        //开始对模型视景的操作
        gl.glMatrixMode(GL10.GL_MODELVIEW)
        //允许写入深度缓冲区
        gl.glDepthMask(true)
        gl.glTranslatef(xPosition, yPosition, zPosition)
        //设置缩放
        objectScale = scaleObjectNow * scaleObject
        gl.glScalef(objectScale, objectScale, objectScale)

        //保存当前状态
        gl.glPushMatrix()
        gl.glColor4f(modelRed, modelGreen, modelBlue, 1f)
        // 画Stl模型
        drawSTLObject(model, gl)
        //恢复之前保存的状态
        gl.glPopMatrix()
    }


    /**
     * 绘制STLObject
     */
    private fun drawSTLObject(stlObject: Model?, gl: GL10) {
        if (stlObject?.vertexBuffer == null || stlObject.norVectorBuffer == null) {
            return
        }
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glEnableClientState(GL10.GL_NORMAL_ARRAY)
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, stlObject.vertexBuffer)
        gl.glNormalPointer(GL10.GL_FLOAT, 0, stlObject.norVectorBuffer)
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, stlObject.facetCount * 3)
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
        gl.glDisableClientState(GL10.GL_NORMAL_ARRAY)
    }

    companion object {
        private const val FRAME_BUFFER_COUNT = 10
        private var bufferCounter = FRAME_BUFFER_COUNT

        // 环境光lightAmbient
        private val lightAB = StlUtil.floatToBuffer(floatArrayOf(0.5f, 0.5f, 0.5f, 1.0f))

        // 漫射光lightDiffuse
        private val lightDB = StlUtil.floatToBuffer(floatArrayOf(1.0f, 1.0f, 1.0f, 1.0f))

        //镜面反射光
        private val lightSB = StlUtil.floatToBuffer(floatArrayOf(1f, 1f, 1f, 1.0f))

        // 光源的位置
        private val lightPB = StlUtil.floatToBuffer(floatArrayOf(0.5f, 0.5f, 0.5f, 1.0f))

        //材质的环境颜色
        private val materialAB = StlUtil.floatToBuffer(floatArrayOf(1f, 1f, 1f, 1f))

        //材质的漫射颜色
        private val materialDB = StlUtil.floatToBuffer(floatArrayOf(1f, 1f, 1f, 1f))

        //材料的镜面反射颜色
        private val materialSB = StlUtil.floatToBuffer(floatArrayOf(1f, 1f, 1f, 1f))

        //模型显示的颜色
        private const val modelRed = 0.93f
        private const val modelGreen = 0.50f
        private const val modelBlue = 0.35f

    }
}