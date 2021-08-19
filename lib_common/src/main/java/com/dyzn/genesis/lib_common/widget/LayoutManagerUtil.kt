package com.dyzn.genesis.lib_common.widget

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dyzn.genesis.lib_common.base.BaseLinearLayoutManager

/**
 *@author YLC-D
 *@create on 2020/12/2 16
 *说明: 获取recyclerView的layoutManager
 */
object LayoutManagerUtil {

    fun getVertical(context: Context) = BaseLinearLayoutManager(context)

    fun getHorizontal(context: Context): BaseLinearLayoutManager {
        val baseLinearLayoutManager = BaseLinearLayoutManager(context)
        baseLinearLayoutManager.orientation = RecyclerView.HORIZONTAL
        return baseLinearLayoutManager
    }

    fun getGrid(context: Context, spanCount: Int): GridLayoutManager {
        return GridLayoutManager(context, spanCount)
    }

}