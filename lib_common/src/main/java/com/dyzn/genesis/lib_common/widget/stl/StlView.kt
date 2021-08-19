package com.dyzn.genesis.lib_common.widget.stl

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PointF
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.MotionEvent
import kotlin.math.sqrt

/**
 * @author YLC-D
 * 使用STLRender的GLSurfaceView
 */
class StlView(context: Context?, attrs: AttributeSet?) : GLSurfaceView(context, attrs) {
    val stlRenderer: StlRenderer = StlRenderer()

    private var xPrevious = 0f
    private var yPrevious = 0f
    private fun changeDistance(scale: Float) {
        stlRenderer.scale = scale
    }

    private val pinchStartPoint = PointF()
    private var pinchStartDistance = 0.0f
    private var touchMode = TOUCH_NONE
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.pointerCount >= TWO) {
            handleMoreThanTwoPoint(event)
        } else if (event.pointerCount == 1) {
            handleOnePoint(event)
        }
        return true
    }

    private fun handleMoreThanTwoPoint(event: MotionEvent) {
        val xPinchMove: Float
        val yPinchMove: Float
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_POINTER_DOWN -> {
                pinchStartDistance = getPinchDistance(event)
                if (pinchStartDistance > BOUNDARY_VALUE) {
                    getPinchCenterPoint(event, pinchStartPoint)
                    xPrevious = pinchStartPoint.x
                    yPrevious = pinchStartPoint.y
                    touchMode = TOUCH_ZOOM
                }
            }
            MotionEvent.ACTION_MOVE -> if (touchMode == TOUCH_ZOOM && pinchStartDistance > 0) {
                // on pinch
                val pt = PointF()
                getPinchCenterPoint(event, pt)
                xPinchMove = pt.x - xPrevious
                yPinchMove = pt.y - yPrevious
                xPrevious = pt.x
                yPrevious = pt.y
                stlRenderer.xAngle += yPinchMove * TOUCH_SCALE_FACTOR
                stlRenderer.zAngle += xPinchMove * TOUCH_SCALE_FACTOR

                //缩放比例
                val pinchScale = getPinchDistance(event) / pinchStartDistance
                changeDistance(pinchScale)
                stlRenderer.requestRedraw()
                invalidate()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_POINTER_UP -> if (touchMode == TOUCH_ZOOM) {
                touchMode = TOUCH_NONE
                pinchStartPoint.x = 0.0f
                pinchStartPoint.y = 0.0f
                invalidate()
            }
            else -> {
            }
        }
    }

    private fun handleOnePoint(event: MotionEvent) {
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_DOWN -> if (touchMode == TOUCH_NONE) {
                touchMode = TOUCH_DRAG
                xPrevious = event.x
                yPrevious = event.y
            }
            MotionEvent.ACTION_MOVE -> if (touchMode == TOUCH_DRAG) {
                val x = event.x
                val y = event.y
                val dx = x - xPrevious
                val dy = y - yPrevious
                xPrevious = x
                yPrevious = y
                // change view point
                stlRenderer.xAngle += dy * TOUCH_SCALE_FACTOR
                //                        stlRenderer.yAngle += dx * TOUCH_SCALE_FACTOR;
                stlRenderer.zAngle += dx * TOUCH_SCALE_FACTOR
                stlRenderer.requestRedraw()
                requestRender()
            }
            MotionEvent.ACTION_UP -> {
                if (touchMode == TOUCH_DRAG) {
                    touchMode = TOUCH_NONE
                }else{
                    stlRenderer.setScale()
                }
            }
            else -> {
            }
        }
    }

    override fun onResume() {
        super.onResume()
        stlRenderer.requestRedraw()
        requestRender()
    }

    /**
     * 获取两指间移动的距离
     */
    private fun getPinchDistance(event: MotionEvent): Float {
        var x = 0f
        var y = 0f
        try {
            x = event.getX(0) - event.getX(1)
            y = event.getY(0) - event.getY(1)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
        return sqrt(x * x + y * y.toDouble()).toFloat()
    }

    /**
     * 获取两指间的中心点
     */
    private fun getPinchCenterPoint(event: MotionEvent, pt: PointF) {
        pt.x = (event.getX(0) + event.getX(1)) * 0.5f
        pt.y = (event.getY(0) + event.getY(1)) * 0.5f
    }

    companion object {
        private const val TOUCH_NONE = 0
        private const val TOUCH_DRAG = 1
        private const val TOUCH_ZOOM = 2
        private const val TWO = 2
        private const val BOUNDARY_VALUE = 50
        /**
         * 这里将偏移数值降低
         */
        private const val TOUCH_SCALE_FACTOR = 180.0f / 320 / 2
    }

    init {
        setRenderer(stlRenderer)
    }
}