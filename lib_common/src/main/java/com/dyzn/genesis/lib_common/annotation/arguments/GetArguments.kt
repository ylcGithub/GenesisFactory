package com.dyzn.genesis.lib_common.annotation.arguments

/**
 *@author YLC-D
 *@create on 2020/12/10 16
 *说明: 用于获取fragment通过navigation传递的参数 注解
 */
@Target(AnnotationTarget.FIELD)
@Retention(value = AnnotationRetention.RUNTIME)
annotation class GetArguments(val key:String)