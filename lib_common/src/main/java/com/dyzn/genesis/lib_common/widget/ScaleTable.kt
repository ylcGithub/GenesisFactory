package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.util.ResUtil
import kotlin.math.cos
import kotlin.math.sin

/**
 *@author YLC-D
 *@create on 2021/6/18 10
 *说明: DIY 模型的 图片拍摄的 刻度表导航控件
 */
class ScaleTable @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    /**
     * 最大外圈的半径
     */
    private var maxRadius = 0f

    /**
     * 中圈的半径
     */
    private var middleRadius = 0f

    /**
     * 最内圈的指针圈半径
     */
    private var minRadius = 0f

    /**
     * 圆圈线条的宽度大小
     */
    private var lineWidth = 0

    /**
     * 圆圈线条的宽度的一半
     */
    private var halfOfLineWidth = 0

    /**
     * 当前控件的中心点
     */
    private val centerPoint = Point()

    /**
     * 刻度的长度
     */
    private var scaleLength = 0f

    /**
     * 指针宽度
     */
    private var handleWidth = 0f

    /**
     * 指针长度
     */
    private var handleLength = 0f

    /**
     * 指针头的半径
     */
    private var handleHeadRadius = 0f

    /**
     * 白色
     */
    private val colorWithe = ResUtil.getColor(R.color.white,context)

    /**
     * 灰色
     */
    private val colorGray = ResUtil.getColor(R.color.color_999,context)

    /**
     * 手机角度对准的颜色提示
     */
    private val colorAim = ResUtil.getColor(R.color.color_main_blue,context)

    /**
     * 已经拍摄角度的刻度颜色
     */
    private val colorHasShot = ResUtil.getColor(R.color.color_main_yellow,context)

    /**
     * 空心画笔
     */
    private val mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 填充画笔
     */
    private val mFillPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 已拍摄的角度集合
     */
    private val filmedList: MutableList<Int> = mutableListOf()

    /**
     * 用于对焦的 刻度的角度列表
     */
    private val scaleAngleList: MutableList<Int> = mutableListOf()

    /**
     * 当前对准的刻度的角度
     * 从scaleAngleList中获取当前对准角度
     */
    private var currentFocusingAngle = 0

    /**
     * 当前手机相对于Z轴的角度
     */
    private var zCurrentAngle = 0f

    /**
     * 刻度间隔角度
     */
    var intervalAngle = 0
        set(value) {
            field = value
            val size: Int = 360 / value
            scaleAngleList.clear()
            for (i in 0 until size) {
                scaleAngleList.add(i * intervalAngle)
            }
            filmedList.clear()
            invalidate()
        }

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.ScaleTable)
        lineWidth = ta.getDimension(R.styleable.ScaleTable_scale_line_width, 4f).toInt()
        minRadius = ta.getDimension(R.styleable.ScaleTable_scale_min_radius, 0f)
        halfOfLineWidth = if (lineWidth % 2 == 0) lineWidth / 2 else lineWidth / 2 + 1
        scaleLength = ta.getDimension(R.styleable.ScaleTable_scale_length, 0f)
        handleLength = ta.getDimension(R.styleable.ScaleTable_pointer_handle_length, 0f)
        handleWidth = ta.getDimension(R.styleable.ScaleTable_pointer_handle_width, 0f)
        handleHeadRadius = ta.getDimension(R.styleable.ScaleTable_pointer_head_radius, 0f)
        ta.recycle()
        mStrokePaint.isDither = true
        mStrokePaint.style = Paint.Style.STROKE

        mFillPaint.isDither = true
        mFillPaint.style = Paint.Style.FILL
        //默认间隔角度为20度
        intervalAngle = 20
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerPoint.x = w / 2
        centerPoint.y = h / 2
        maxRadius = (w / 2 - lineWidth).toFloat()
        middleRadius = maxRadius - minRadius / 3
    }

    /**
     * 更新手机当前角度
     *
     * @param angle 角度（Z轴）
     */
    fun updateAngle(angle: Float) {
        this.zCurrentAngle = angle
        invalidate()
    }

    fun resetFilmedList() {
        filmedList.clear()
    }

    /**
     * 设置已拍摄图片角度
     *
     * @param angle 已拍摄图片角度
     */
    fun setHasShotAngle(angle: Int) {
        filmedList.add(angle)
        if (filmedList.size == scaleAngleList.size) {
            visibility = GONE
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (visibility != VISIBLE) {
            canvas?.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            return
        }
        //绘制最外层圆形 最大圆形
        mStrokePaint.color = colorGray
        mStrokePaint.strokeWidth = lineWidth.toFloat()
        canvas?.drawCircle(
            centerPoint.x.toFloat(),
            centerPoint.y.toFloat(),
            maxRadius - halfOfLineWidth,
            mStrokePaint
        )
        //绘制第二个圆形 中圈刻度所在圆形
        mStrokePaint.color = colorWithe
        canvas?.drawCircle(
            centerPoint.x.toFloat(),
            centerPoint.y.toFloat(),
            middleRadius - halfOfLineWidth,
            mStrokePaint
        )
        //获取指针当前状态
        val type: Int = getAimType()
        //绘制刻度
        drawScale(canvas, type)
        //绘制指针
        drawPointer(canvas, type)
    }

    companion object {
        private const val ANIM_TYPE = 1
        private const val FILMED_TYPE = 2
        private const val NORMAL_TYPE = 3
    }


    /**
     * 当前是否对焦可拍摄角度
     *
     * @return 对焦type
     * type 1 对准可拍摄角度 2当前刻度已拍摄图片 3 未对焦角度
     */
    private fun getAimType(): Int {
        return when {
            isFilmed() -> {
                FILMED_TYPE
            }
            isAnim() -> {
                ANIM_TYPE
            }
            else -> {
                NORMAL_TYPE
            }
        }
    }

    private fun isFilmed(): Boolean {
        filmedList.forEach {
            if (withinTheInterval(it)) return true
        }
        return false
    }

    private fun isAnim(): Boolean {
        scaleAngleList.forEach {
            if (withinTheInterval(it)) {
                currentFocusingAngle = it
                notify(true,it)
                return true
            }
        }
        notify(false,0)
        return false
    }

    /**
     * 判断当前角度是否在刻度的区间内
     *
     * @param scaleAngle 刻度
     * @return zCurrentAngle是否在刻度区间内
     */
    private fun withinTheInterval(scaleAngle: Int): Boolean {
        //精度值
        val mAccuracy = 3.5f
        return if (scaleAngle == 0) {
            //0 刻度为边界刻度 比较特殊单独比较
            zCurrentAngle <= mAccuracy || zCurrentAngle >= 360 - mAccuracy
        } else {
            zCurrentAngle >= (scaleAngle - mAccuracy) && zCurrentAngle <= scaleAngle + mAccuracy
        }
    }

    var shotListener: StandardChart.CanShotListener? = null
    private fun notify(shot: Boolean, currentFocusingAngle: Int) {
        shotListener?.shot(shot, currentFocusingAngle)
    }

      /**
     * 绘制刻度
     *
     * @param canvas 画布
     * @param type   当前角度对准的类型
     */
    private fun drawScale(canvas:Canvas?, type:Int) {
        scaleAngleList.forEach {
            getPointFromAngleAndRadius(true,it,middleRadius)
            getPointFromAngleAndRadius(false, it, middleRadius - scaleLength)
            mStrokePaint.color = colorWithe
            if (type == ANIM_TYPE && it == currentFocusingAngle) {
                mStrokePaint.color = colorAim
            } else if (filmedList.contains(it)) {
                mStrokePaint.color = colorHasShot
            }
            canvas?.drawLine(startPoint.x.toFloat(), startPoint.y.toFloat(), endPoint.x.toFloat(), endPoint.y.toFloat(), mStrokePaint)
        }
    }

    private  val startPoint =  Point()
    private  val endPoint =  Point()

    /**
     * 根据角度和半径，求一个点的坐标
     *
     * @param angle  角度
     * @param radius 半径
     */
    private fun getPointFromAngleAndRadius(isStartPoint:Boolean, angle:Int, radius:Float) {
        val x =  (radius * cos(angle * Math.PI / 180) + centerPoint.x).toInt()
        val y =  (radius * sin(angle * Math.PI / 180) + centerPoint.y).toInt()
        if (isStartPoint) {
            startPoint.set(x, y)
        } else {
            endPoint.set(x, y)
        }
    }

    private fun drawPointer(canvas:Canvas?, type:Int) {
        //绘制中心圆形
        val curColor = getAimColorByType(type)
        mStrokePaint.color = curColor
        mFillPaint.color = curColor
        canvas?.drawCircle(centerPoint.x.toFloat(), centerPoint.y.toFloat(), minRadius - halfOfLineWidth, mStrokePaint)
        //绘制指针柄
        mStrokePaint.strokeWidth = handleWidth
        getPointFromAngleAndRadius(true, zCurrentAngle.toInt(), minRadius - halfOfLineWidth)
        getPointFromAngleAndRadius(false, zCurrentAngle.toInt(), handleLength + minRadius)
        canvas?.drawLine(startPoint.x.toFloat(), startPoint.y.toFloat(), endPoint.x.toFloat(), endPoint.y.toFloat(), mStrokePaint)
        //绘制指针圆头
        canvas?.drawCircle(endPoint.x.toFloat(), endPoint.y.toFloat(), handleHeadRadius, mFillPaint)
    }

    @ColorInt
    private fun getAimColorByType(type:Int):Int {
        return when (type) {
            ANIM_TYPE -> {
                colorAim
            }
            FILMED_TYPE -> {
                colorHasShot
            }
            NORMAL_TYPE -> {
                colorWithe
            }
            else -> {
                colorWithe
            }
        }
    }
}