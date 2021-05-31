package com.dyzn.genesis.lib_common.annotation.arguments

import android.app.Activity
import androidx.fragment.app.Fragment
import com.dyzn.genesis.lib_common.util.LogUtil
import java.lang.reflect.Field

/**
 *@author YLC-D
 *@create on 2020/12/11 16
 *说明:
 */
object ArgumentsParse {
    /**
     * 获取intent跳转fragment传递的参数
     *
     * @param fragment fragment
     */
    fun injectParams(fragment: Fragment) {
        val aClass: Class<out Fragment?> = fragment.javaClass
        //获得此类所有的成员
        val declaredFields = aClass.declaredFields
        for (field in declaredFields) {
            if (field == null) {
                continue
            }
            // 判断属性是否被InjectParams注解声明
            if (field.isAnnotationPresent(GetArguments::class.java)) {
                val injectView: GetArguments = field.getAnnotation(GetArguments::class.java) ?: continue
                //获得了注解中设置的String key 值
                val key: String = injectView.key
                //设置访问权限，允许操作private的属性
                field.isAccessible = true
                val bundle = fragment.arguments ?: continue
                setValue(fragment, field, bundle[key])
            }
        }
    }

    /**
     * 给参数设置值
     */
    private fun setValue(activity: Fragment, field: Field, value: Any?) {
        try {
            //反射赋值
            field[activity] = value
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
            LogUtil.log("反射设置参数值错误:${e.message}" )
        }
    }
}