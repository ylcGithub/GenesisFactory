package com.dyzn.genesis.lib_common.network.data

/**
 * @author YLC-D
 * @create on 2020/02/03 17
 * 说明: 网络数据返回的普通类型 基本参数 提取封装基类
 */
data class BaseResponse<T>(val rescode: Int, val errorMsg: String?, val body: T?)
