package com.dyzn.genesis.lib_base_mvvm.base

import androidx.lifecycle.LifecycleOwner

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明: 加载动画的接口
 */
interface ILoad : LifecycleOwner {
    fun showLoading(message: String = "")

    fun hideLoading()
}