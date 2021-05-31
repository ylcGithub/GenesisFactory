package com.dyzn.genesis.lib_common.base

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明: 加载动画的接口
 */
interface ILoad {
    fun showLoading(message: String = "")

    fun hideLoading()
}