package com.dyzn.genesis.module_process.netty

import com.dyzn.genesis.module_process.netty.gen.DataType
import com.dyzn.genesis.module_process.netty.gen.OurMessage
import com.dyzn.genesis.module_process.util.ProcessUtil
import com.jeremyliao.liveeventbus.LiveEventBus
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.timeout.IdleState
import io.netty.handler.timeout.IdleStateEvent

/**
 * @author Administrator
 */
class NettyClientHandler internal constructor(private val handler: ClientConnectHandler?) :
    SimpleChannelInboundHandler<OurMessage?>() {
    /**
     * 接收到服务器消息
     */
    override fun channelRead0(ctx: ChannelHandlerContext, ourMessage: OurMessage?) {
        if (dataTypeIsRight(ourMessage)) {
            //分发消息
            LiveEventBus.get(ProcessUtil.getOurMsgKey(ourMessage?.data_type)).post(ourMessage)
        }
    }

    private fun dataTypeIsRight(ourMessage: OurMessage?): Boolean {
        val msg = ourMessage ?: OurMessage().setData_type(DataType.PingCmd)
        return msg.getData_type() != DataType.PingCmd
    }

    override fun channelActive(ctx: ChannelHandlerContext) {
        handler?.connected()
    }

    /**
     * 用户事件处理，这里处理超时逻辑
     *
     * @param ctx 上下文
     * @param evt 文件
     */
    override fun userEventTriggered(ctx: ChannelHandlerContext, evt: Any) {
        val stateEvent = evt as IdleStateEvent
        when (stateEvent.state()) {
            IdleState.READER_IDLE, IdleState.WRITER_IDLE -> ctx.close()
            IdleState.ALL_IDLE -> {
            }
            else -> {
            }
        }
        handler?.error(Exception("心跳超时"))
    }

    @Throws(Exception::class)
    override fun channelInactive(ctx: ChannelHandlerContext) {
        super.channelInactive(ctx)
        handler?.error(Exception("channel Inactive"))
    }

    override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
        ctx.close()
        handler?.error(Exception(cause))
    }
}