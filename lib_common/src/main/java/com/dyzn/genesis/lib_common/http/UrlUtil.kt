package com.dyzn.genesis.lib_common.http

/**
 *@author YLC-D
 *@create on 2021/1/21 10
 *说明:
 */
object UrlUtil {

    fun getStlDownloadUrl(stlId:String):String{
        return "app/file/v1/download/file/${stlId}.stl"
    }

}