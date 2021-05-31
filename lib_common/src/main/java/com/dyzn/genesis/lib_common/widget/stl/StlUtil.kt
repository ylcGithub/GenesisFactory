package com.dyzn.genesis.lib_common.widget.stl

import okhttp3.internal.and
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer

/**
 * @author YLC-D
 * 解析stl文件用到的工具类
 */
internal object StlUtil {
    fun floatToBuffer(a: FloatArray): FloatBuffer {
        //先初始化buffer，数组的长度*4，因为一个float占4个字节
        val bb = ByteBuffer.allocateDirect(a.size * 4)
        //数组排序用nativeOrder
        bb.order(ByteOrder.nativeOrder())
        val buffer = bb.asFloatBuffer()
        buffer.put(a)
        buffer.position(0)
        return buffer
    }

    fun byte4ToInt(bytes: ByteArray, offset: Int): Int {
        val b3: Int = bytes[offset + 3] and 0xFF
        val b2: Int = bytes[offset + 2] and 0xFF
        val b1: Int = bytes[offset + 1] and 0xFF
        val b0: Int = bytes[offset] and 0xFF
        return b3 shl 24 or (b2 shl 16) or (b1 shl 8) or b0
    }

    fun byte2ToShort(bytes: ByteArray, offset: Int): Short {
        val b1: Int = bytes[offset + 1] and 0xFF
        val b0: Int = bytes[offset] and 0xFF
        return (b1 shl 8 or b0).toShort()
    }

    fun byte4ToFloat(bytes: ByteArray, offset: Int): Float {
        return java.lang.Float.intBitsToFloat(byte4ToInt(bytes, offset))
    }
}