package com.dyzn.genesis.module_process.netty.codec

import com.dyzn.genesis.module_process.netty.gen.OurMessage
import io.netty.buffer.ByteBuf
import io.netty.handler.codec.ByteToMessageDecoder
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.apache.thrift.TException
import org.apache.thrift.protocol.TBinaryProtocol
import org.apache.thrift.transport.TIOStreamTransport
import org.apache.thrift.transport.TTransport
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

/**
 * Package自定义bytebuf协议
 * 分割规则：LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,5,4)
 * created_at: 2019-02-13 14:36
 * @author  tanyi
 */
class MyPackage : Codec<MyPackage?> {
    /** 魔数  */
    private var magicNumber: Int

    /** 协议版本  */
    private var version: Byte

    /** 序列化算法，1=thrift  */
    private var serializ: Byte

    /** 数据长度  */
    private var length = 0

    /** 消息内容  */
    var content: OurMessage? = null

     internal constructor() {
        magicNumber = MAGIC_NUMBER
        version = 1
        serializ = 1
    }

    internal constructor(content: OurMessage?) {
        magicNumber = MAGIC_NUMBER
        version = 1
        serializ = 1
        this.content = content
    }

    override fun encode(out: ByteBuf?) {
        // 序列化
        val outBody = ByteArrayOutputStream()
        val transport: TTransport = TIOStreamTransport(outBody)
        //二进制编码格式进行数据传输
        val tp = TBinaryProtocol(transport)
        try {
            content!!.write(tp)
        } catch (e: TException) {
            e.printStackTrace()
        }
        val buf = outBody.toByteArray()
        out!!.writeInt(magicNumber)
        out.writeByte(version.toInt())
        out.writeByte(serializ.toInt())
        out.writeInt(buf.size)
        out.writeBytes(buf)
    }

    override fun decode(inByte: ByteBuf?): MyPackage {
        //魔数
        magicNumber = inByte!!.readInt()
        //版本
        version = inByte.readByte()
        //序列化方式
        serializ = inByte.readByte()
        length = inByte.readInt()
        val body = ByteArray(length)
        inByte.readBytes(body)
        //反序列化
        val bis = ByteArrayInputStream(body)
        val transport: TTransport = TIOStreamTransport(bis)
        val tp = TBinaryProtocol(transport)
        val msg = OurMessage()
        try {
            msg.read(tp)
        } catch (e: TException) {
            e.printStackTrace()
        }
        content = msg
        return this
    }

    companion object {
        private const val MAGIC_NUMBER = 0x125//参数说明：最大数据长度，长度域位置下标，长度域长度

        /** 获取分割规则  */
        @JvmStatic
        val basedFrameDecoder: ByteToMessageDecoder
            get() =//参数说明：最大数据长度，长度域位置下标，长度域长度
                LengthFieldBasedFrameDecoder(Int.MAX_VALUE, 6, 4)
    }
}