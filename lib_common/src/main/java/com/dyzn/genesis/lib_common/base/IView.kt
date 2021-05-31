package com.dyzn.genesis.lib_common.base

import androidx.annotation.LayoutRes
import androidx.lifecycle.LifecycleOwner

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明: 布局文件 和 数据初始化的接口
 */
interface IView{
    @LayoutRes
    fun getLayoutId(): Int
    fun initData()
}