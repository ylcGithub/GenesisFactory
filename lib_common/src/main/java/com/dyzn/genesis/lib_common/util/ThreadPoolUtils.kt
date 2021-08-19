package com.dyzn.genesis.lib_common.util

import org.apache.commons.lang3.concurrent.BasicThreadFactory
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledThreadPoolExecutor

/**
 *@author YLC-D
 *@create on 2020/11/17 15
 *说明:
 */
object ThreadPoolUtils {

    fun getExecutorService(name: String): ScheduledExecutorService {
        return getExecutorService(name, 1)
    }

    fun getExecutorService(name: String, size: Int): ScheduledExecutorService {
        return ScheduledThreadPoolExecutor(
            size, BasicThreadFactory.Builder().namingPattern("robot$name-schedule-pool-%d")
                .daemon(true).build()
        )
    }
}