package com.dyzn.genesis.lib_common.config

import com.dyzn.genesis.lib_common.BuildConfig

/**
 *@author YLC-D
 *@create on 2020/11/2 14
 *说明:
 */
object UrlConfig {
    val HTTP_SERVER: String get() = if (!BuildConfig.DEBUG) "http://192.168.5.218:8080/" else "http://47.107.95.201:8080/"

    const val SERVER_IP: String = "47.107.95.201"

    /**
     * thrift 专用
     */
    const val SERVER_PORT = 8899
}