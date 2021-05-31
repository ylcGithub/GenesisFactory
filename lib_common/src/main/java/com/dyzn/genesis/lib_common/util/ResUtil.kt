package com.dyzn.genesis.lib_common.util

import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat
import com.dyzn.genesis.lib_common.base.BaseApplication

/**
 * @author YLC-D
 * @create on 2020/10/26
 * 说明:资源类相关的工具方法
 */
object ResUtil {
    @ColorInt
    fun getColor(@ColorRes colorId: Int): Int {
        return ContextCompat.getColor(BaseApplication.getAppContext(), colorId)
    }

    fun getDimen(@DimenRes dimenId: Int): Float {
        return BaseApplication.getAppContext().resources.getDimension(dimenId)
    }

    fun getString(@StringRes stringId: Int): String {
        return BaseApplication.getAppContext().resources.getString(stringId)
    }

    fun getDrawable(@DrawableRes drawableId: Int): Drawable? {
        return ContextCompat.getDrawable(BaseApplication.getAppContext(), drawableId)
    }
}