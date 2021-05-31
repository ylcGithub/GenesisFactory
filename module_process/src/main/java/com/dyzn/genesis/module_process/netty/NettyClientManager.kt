package com.dyzn.genesis.module_process.netty

import com.dyzn.genesis.lib_common.config.UrlConfig
import com.dyzn.genesis.lib_common.util.ThreadPoolUtils
import com.dyzn.genesis.module_process.netty.gen.*
import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelFutureListener
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioSocketChannel
import java.util.concurrent.TimeUnit

/**
 *@author YLC-D
 *@create on 2020/11/17 15
 *说明:
 */
object NettyClientManager {
    private const val SERVER_IP = UrlConfig.SERVER_IP
    private const val SERVER_PORT = UrlConfig.SERVER_PORT
    private val executorService = ThreadPoolUtils.getExecutorService("netty-send-message", 10)
    private val eventLoopGroup = NioEventLoopGroup(1)
    var handler: ClientConnectHandler? = null
    private var client: Channel? = null

    /**
     * 发送消息状态
     */
    private var msgSendState = true

    /**
     * 获取当前是否能发送消息
     */
    fun isMsgSendState(): Boolean {
        val active = client?.isActive ?: false
        if (!msgSendState && active) close()
        return active && msgSendState
    }

    /**
     * 初始化netty客户端
     */
    @Synchronized
    fun init() {
        if (handler == null) {
            return
        }
        if (isMsgSendState()) return

        executorService.schedule({
            try {
                val bootstrap = Bootstrap()
                bootstrap.group(eventLoopGroup).channel(NioSocketChannel::class.java)
                    .handler(NettyClientFilter(handler!!))
                val channelFuture = bootstrap.connect(
                    SERVER_IP,
                    SERVER_PORT
                ).sync()
                client = channelFuture.channel()
                client?.closeFuture()?.sync()
            } catch (e: Exception) {
                try {
                    TimeUnit.SECONDS.sleep(2)
                    init()
                } catch (e1: InterruptedException) {
                    e1.printStackTrace()
                }
            }
        }, 0, TimeUnit.MILLISECONDS)
    }

    /**
     * 发送消息
     */
    fun sendMsg(type: DataType, msg: Any?) {
        executorService.schedule({
            val ourMessage = OurMessage()
            ourMessage.setData_type(type)
            ourMessage.setMsg_flag(MsgFlag.toDevice)
            var body: DataBody? = null
            if (msg == null && DataType.PingCmd == type) {
                ourMessage.setMsg_flag(MsgFlag.toServer)
            } else {
                body = getDataBody(type, msg)
                when (type) {
                    DataType.LoginCmd, DataType.LogoutCmd -> ourMessage.setMsg_flag(
                        MsgFlag.toServer
                    )
                    else -> {
                    }
                }
            }
            if (body != null) {
                ourMessage.setData_body(body)
            }
            sendMsg(ourMessage)
        }, 0, TimeUnit.MILLISECONDS)
    }

    /**
     * 发送消息
     */
    private fun sendMsg(msg: OurMessage?) {
        if (client?.isActive == true) {
            client!!.writeAndFlush(msg).addListener(ChannelFutureListener { future: ChannelFuture ->
                msgSendState = future.isSuccess
                if (!msgSendState && handler != null) {
                    handler!!.error(java.lang.Exception(future.cause()))
                }
            })
        }
    }

    private fun getDataBody(type: DataType, msg: Any?): DataBody? {
        var body: DataBody? = DataBody()
        when (type) {
            DataType.LoginCmd -> body!!.loginMsg = msg as LoginMsg?
            DataType.BindCmd -> body!!.bindMsg = msg as BindMsg?
            DataType.ChooseModelCmd -> body!!.chooseModelMsg = msg as ChooseModelMsg?
            DataType.RunOrStopCmd -> body!!.runOrStopMsg = msg as RunOrStopMsg?
            DataType.OpenOrCloseCamCmd -> body!!.openOrCloseCamMsg = msg as OpenOrCloseCamMsg?
            DataType.ClampOrReleaseCmd -> body!!.clampOrReleaseMsg = msg as ClampOrReleaseMsg?
            DataType.SetActualCoordCmd -> body!!.setActualCoordMsg = msg as SetActualCoordMsg?
            DataType.mpgCmd -> body!!.mpgMsg = msg as MPGMsg?
            DataType.SetSysParamCmd -> body!!.setSysParamMsg = msg as SetSysParamMsg?
            DataType.SetFeedRateCmd -> body!!.setFeedRateMsg = msg as SetFeedRateMsg?
            DataType.AutoRunNextStepCmd -> body!!.autoRunMsg = msg as AutoRunNextStepMsg?
            else -> body = null
        }
        return body
    }

    fun close() {
        client?.close()
        client = null
    }
}