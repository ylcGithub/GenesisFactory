package com.dyzn.genesis.module_process.netty

import com.dyzn.genesis.module_process.netty.gen.DataType
import io.netty.util.internal.logging.InternalLoggerFactory
import io.netty.util.internal.logging.Slf4JLoggerFactory

/**
 * MessageHelper消息发送类
 * created_at: 2019-02-12 16:27
 * @author  tanyi
 */
object MessageHelper {
    /** 连接状态反馈  */
    var handler: ClientConnectHandler? = null

    /**
     * 初始化客户端连接
     */
    fun init() {
        //解决netty日志报错问题
        InternalLoggerFactory.setDefaultFactory(Slf4JLoggerFactory.INSTANCE)
        NettyClientManager.handler = handler
        NettyClientManager.init()
    }

    /**
     * 发送消息
     *
     * @param type 消息类型
     * @param msg  消息对象body
     */
    fun sendMsg(type: DataType, msg: Any?) {
        NettyClientManager.sendMsg(type, msg)
    }

    /**
     * 当前是否能够发送消息
     *
     * @return 是否可以发送消息
     */
    fun sendMsgAble(): Boolean {
        return NettyClientManager.isMsgSendState()
    }

    /**
     * 关闭连接
     */
    fun close() {
        NettyClientManager.close()
    }
}