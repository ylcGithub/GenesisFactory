package com.dyzn.genesis.lib_common.util

import android.util.Log
import com.dyzn.genesis.lib_common.BuildConfig;

/**
 * @author Administrator
 * @create on 2020/10/3 0003
 * 说明:打印的封装工具 暂时统一使用警告错误级别的打印
 */
object LogUtil {
    var DEBUG: Boolean = true
    fun log(errorMsg: String) {
        log("小工厂", errorMsg)
    }

    fun log(tag: String, errorMsg: String) {
        if (!BuildConfig.DEBUG && DEBUG) {
            CacheFileUtil.saveLogToLocal(tag,errorMsg)
        } else if (BuildConfig.DEBUG) {
            Log.e(tag, errorMsg)
        }
    }
}