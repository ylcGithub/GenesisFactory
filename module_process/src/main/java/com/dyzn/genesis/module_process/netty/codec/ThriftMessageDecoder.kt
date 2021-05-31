package com.dyzn.genesis.module_process.netty.codec

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.ByteToMessageDecoder

/**
 * @author tanyi
 * 负责把用户请求的thrift协议内容解析为一个ThriftMessage 对象
 */
class ThriftMessageDecoder : ByteToMessageDecoder() {
    private val codec: MyPackage = MyPackage()
    override fun decode(ctx: ChannelHandlerContext, inByte: ByteBuf, out: MutableList<Any>) {
        val aMyPackage = codec.decode(inByte)
        aMyPackage.content?.let {out.add(it)}
    }
}