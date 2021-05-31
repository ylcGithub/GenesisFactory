package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.dyzn.genesis.lib_common.R

/**
 *@author YLC-D
 *@create on 2021/4/8 16
 *说明:
 */
class AnimBgView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    init {
        setBackgroundResource(R.drawable.common_bg)
    }
}