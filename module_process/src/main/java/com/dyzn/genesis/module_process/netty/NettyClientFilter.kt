package com.dyzn.genesis.module_process.netty

import com.dyzn.genesis.module_process.netty.codec.MyPackage.Companion.basedFrameDecoder
import com.dyzn.genesis.module_process.netty.codec.ThriftMessageDecoder
import com.dyzn.genesis.module_process.netty.codec.ThriftMessageEncoder
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.timeout.IdleStateHandler

/**
 * @author Administrator
 */
class NettyClientFilter internal constructor(private val handler: ClientConnectHandler) :
    ChannelInitializer<NioSocketChannel>() {
    override fun initChannel(ch: NioSocketChannel) {
        val pipeline = ch.pipeline()

        //配置超时时间，配合心跳使用，参数说明：接收消息超时时间，发送消息超时时间，
        pipeline.addLast(IdleStateHandler(6, 6, 0))
        //粘包拆包
        pipeline.addLast(basedFrameDecoder)
        //解码器
        pipeline.addLast(ThriftMessageDecoder())
        //编码器
        pipeline.addLast(ThriftMessageEncoder())
        //业务逻辑处理
        pipeline.addLast(NettyClientHandler(handler))
    }
}