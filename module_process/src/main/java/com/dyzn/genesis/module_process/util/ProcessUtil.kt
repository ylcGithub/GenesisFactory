package com.dyzn.genesis.module_process.util

import com.dyzn.genesis.module_process.netty.gen.DataType

/**
 *@author YLC-D
 *@create on 2020/11/24 10
 *说明:
 */
object ProcessUtil {
    fun getOurMsgKey(dataType:DataType?):String{
        return "OurMessage_${dataType?.value}"
    }
}