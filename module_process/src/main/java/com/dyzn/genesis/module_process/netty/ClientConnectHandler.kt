package com.dyzn.genesis.module_process.netty

/**
 * created_at: 2019-01-15 11:12
 *
 * @author tanyi
 */
interface ClientConnectHandler {
    /**
     * 错误回调
     *
     * @param exception 报错信息
     */
    fun error(exception: Exception?)

    /**
     * 连接成功
     */
    fun connected()
}