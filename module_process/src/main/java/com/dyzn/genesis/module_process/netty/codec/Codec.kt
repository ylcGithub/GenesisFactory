package com.dyzn.genesis.module_process.netty.codec

import io.netty.buffer.ByteBuf

interface Codec<T> {
    /**
     * 编码
     * @param out 字节缓存
     */
    fun encode(out: ByteBuf?)

    /**
     * 解码
     * @param inByte 字节缓存
     * @return 返回
     */
    fun decode(inByte: ByteBuf?): T
}