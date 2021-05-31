package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatEditText
import com.dyzn.genesis.lib_common.util.FontCustom

/**
 *@author YLC-D
 *@create on 2021/5/25 09
 *说明:
 */
class AppEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatEditText(context, attrs, defStyleAttr) {
    init {
        //不是预览页面情况下，设置字体样式
        if (!isInEditMode) {
            typeface = FontCustom.setFont(context)
            //避免自定义editText无法获取焦点
            isFocusableInTouchMode = true
        }
        gravity = Gravity.CENTER_VERTICAL
    }

    fun notifyTypeFace() {
        typeface = FontCustom.setFont(context)
    }
}