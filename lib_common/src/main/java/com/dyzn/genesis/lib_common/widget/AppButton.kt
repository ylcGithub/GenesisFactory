package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.util.FontCustom

/**
 *@author YLC-D
 *@create on 2021/2/23 10
 *说明:
 */
class AppButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatButton(context, attrs, defStyle) {

    init {
        val ta = context.obtainStyledAttributes(attrs,R.styleable.AppTitle)
        ta.recycle()
        gravity = Gravity.CENTER
        setTextColor(ContextCompat.getColor(context,R.color.white))
        //不是预览页面情况下，设置字体样式
        if (!isInEditMode) {
            typeface = FontCustom.setFont(context)
        }
    }

    fun notifyTypeFace() {
        typeface = FontCustom.setFont(context)
    }
}