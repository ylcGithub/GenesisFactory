package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.util.ResUtil
import kotlin.math.abs

/**
 *@author YLC-D
 *@create on 2021/6/18 10
 *说明: 自定义模型的 标准图拍摄导航控件
 */
class StandardChart @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {
    /**
     * 控件中心点
     */
    private var cPoint: Point = Point(0, 0)

    /**
     * 标准图导航框
     */
    private var box: RectF = RectF()

    /**
     * 空心画笔 初始化抗锯齿的画笔
     */
    private var mStrokePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 文字画笔
     */
    private var mTextPaint = TextPaint()

    /**
     * 普通情况的白色颜色
     */
    private val colorWithe = ResUtil.getColor(R.color.white)

    /**
     * 标记色 蓝色
     */
    private val colorMark = ResUtil.getColor(R.color.color_main_blue,context)

    /**
     * 手机相对于X轴的夹角
     */
    private var xCurrentAngle = 0f

    /**
     * 手机相对于Y轴的夹角
     */
    private var yCurrentAngle = 0f
    private var lineWidth = 0f

     /**
     * 纵向的边界值1
     */
    private var verRight = false
    private var horRight = false


    private fun kanShot():Boolean {
        return verRight && horRight
    }

    init {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.StandardChart)
        lineWidth = ta.getDimension(R.styleable.StandardChart_standard_line_width, 0f)
        ta.recycle()
        mStrokePaint.isDither = true
        mStrokePaint.style = Paint.Style.STROKE
        mStrokePaint.strokeWidth = lineWidth

        mTextPaint.color = ResUtil.getColor(R.color.color_333,context)
        mTextPaint.textSize = ResUtil.getDimen(R.dimen.font_size_14,context)
    }


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val hw = w / 2
        val hh = h / 2
        cPoint.x = hw
        cPoint.y = hh
        box.left = cPoint.x - hw + lineWidth
        box.top = cPoint.y - hh + lineWidth
        box.right = cPoint.x + hw - lineWidth
        box.bottom = cPoint.x + hh - lineWidth
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (visibility != VISIBLE) {
            canvas?.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
            return
        }

        //绘制正方形外框
        mStrokePaint.color = colorWithe
        canvas?.drawRect(box, mStrokePaint)
        //绘制白色的纵横交叉底线
        canvas?.drawLine(cPoint.x.toFloat(), box.top, cPoint.x.toFloat(), box.bottom, mStrokePaint)
        canvas?.drawLine(box.left, cPoint.y.toFloat(), box.right, cPoint.y.toFloat(), mStrokePaint)
        //绘制横向导航线条
        drawHorLine(canvas)
        //绘制纵向导航线条
        drawVerLine(canvas)
        //判断是否可以拍摄
        if (kanShot()) {
            mStrokePaint.color = colorMark
            canvas?.drawRect(box, mStrokePaint)
            notify(true)
        } else {
            notify(false)
        }
    }

     private fun drawHorLine(canvas:Canvas?) {
         mStrokePaint.color = colorMark
         //横轴方向的导航
         val horBoundaryValue2 = 10.0
         val boundaryValue3 = 90
         if (yCurrentAngle in -10.0..horBoundaryValue2) {
             //Y轴的角度正确
             canvas?.drawLine(box.left, cPoint.y.toFloat(), box.right, cPoint.y.toFloat(), mStrokePaint)
             horRight = true
         } else if (yCurrentAngle > boundaryValue3 || yCurrentAngle < -boundaryValue3) {
             canvas?.drawText("不能仰视拍摄标准图", box.left + 20, box.top + 20, mTextPaint)
         } else if (yCurrentAngle > horBoundaryValue2) {
             //Y轴的角度不正确 向右偏移太多了
             val ratio = yCurrentAngle / 80f
             val w = ((box.right - box.left) * (1 - ratio))
             canvas?.drawLine(box.right - w, cPoint.y.toFloat(), box.right, cPoint.y.toFloat(), mStrokePaint)
         } else {
             //Y轴的角度不正确 向左偏移太多了
             val ratio = abs(yCurrentAngle / 80f)
             val w = ((box.right - box.left) * (1 - ratio))
             canvas?.drawLine(box.left, cPoint.y.toFloat(), box.left + w, cPoint.y.toFloat(), mStrokePaint)
         }
    }

    private fun drawVerLine(canvas:Canvas?) {
        // 纵向的边界值
        val verBoundaryValue1 = -82.0
        verRight = false
        //纵轴方向的导航
        if (xCurrentAngle in -90.0..verBoundaryValue1) {
            //x轴的角度正确
            canvas?.drawLine(cPoint.x.toFloat(), box.top, cPoint.x.toFloat(), box.bottom, mStrokePaint)
            verRight = true
        } else {
            //x轴的角度不正确
            val ratio = abs(xCurrentAngle / verBoundaryValue1)
            val h = ((box.bottom - box.top) * ratio).toFloat()
            canvas?.drawLine(cPoint.x.toFloat(), box.top, cPoint.x.toFloat(), box.top + h, mStrokePaint)
        }
    }
    var shotListener: CanShotListener? = null

    interface CanShotListener {
        /**
         * 通知状态
         *
         * @param shot                 是否可以拍摄
         * @param currentFocusingAngle 当前可以拍摄的角度
         */
        fun shot(shot: Boolean, currentFocusingAngle: Int)
    }

    private fun notify(shot: Boolean) {
        shotListener?.shot(shot, -1)
    }
}