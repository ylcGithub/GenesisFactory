package com.dyzn.genesis.module_process.netty.codec

import com.dyzn.genesis.module_process.netty.gen.OurMessage
import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToByteEncoder

/**
 * @author tanyi
 */
class ThriftMessageEncoder : MessageToByteEncoder<OurMessage?>() {
    override fun encode(
        channelHandlerContext: ChannelHandlerContext,
        msg: OurMessage?,
        out: ByteBuf
    ) {
        val codec = MyPackage(msg)
        codec.encode(out)
    }
}