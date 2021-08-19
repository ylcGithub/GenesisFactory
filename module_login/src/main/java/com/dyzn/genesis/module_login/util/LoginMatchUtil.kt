package com.dyzn.genesis.module_login.util

import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.util.ResUtil
import org.apache.commons.lang3.StringUtils

/**
 *@author YLC-D
 *@create on 2020/12/9 09
 *说明:登录模块的条件匹配工具类
 */
object LoginMatchUtil {

    fun isPhoneNum(mobileNum: String?): Boolean {
        //判断字符串是否符合手机号码格式
        //移动号段: 134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188
        //联通号段: 130,131,132,145,155,156,170,171,175,176,185,186
        //电信号段: 133,149,153,170,173,177,180,181,189
        //@param str
        //@return 待检测的字符串
        //// "[1]"代表下一位为数字可以是几，
        //"[0-9]"代表可以为0-9中的一个，
        //"[5,7,9]"表示可以是5,7,9中的任意一位,
        //[^4]表示除4以外的任何一个,
        //\\d{9}"代表后面是可以是0～9的数字，有9位。
        return if (StringUtils.isEmpty(mobileNum)) {
            false
        } else {
            val telRegex =
                Regex("^((13[0-9])|(14[5,7,9])|(15[^4])|(18[0-9])|(17[0,1,3,5,6,7,8]))\\d{8}$")
            mobileNum?.matches(telRegex) ?: false
        }
    }

    /**
     * 6~9位字符，至少包含数字.字母.符号中的2种
     * @param pwd    密码
     * @return 返回是否符合密码规范
     */
    fun isPwd(pwd: String?): Boolean {
        if (StringUtils.isEmpty(pwd)) {
            return false
        }
        val pswRegex = Regex("(?!^[0-9]+$)(?!^[A-z]+$)(?!^[^A-z0-9]+$)^.{6,9}$")
        return pwd?.matches(pswRegex) ?: false
    }

    fun isAuthCode(code: String?): Boolean {
        return StringUtils.isNotEmpty(code) && code?.length ?: 0 >= 4
    }

    fun kanRegister(phone: String?, code: String?, pwd: String?, confirmPwd: String?): Boolean {
        return isPhoneNum(phone) && isAuthCode(code) && isPwd(pwd) && StringUtils.equals(
            pwd,
            confirmPwd
        )
    }

    fun kanLogin(phone: String?, pwd: String?, pwdLogin: Boolean?): Boolean {
        val rightPwdCode = if (pwdLogin == true) isPwd(pwd) else isAuthCode(pwd)
        return isPhoneNum(phone) && rightPwdCode
    }

    fun kanGetCode(phone: String?, codeString: String?): Boolean {
        return isPhoneNum(phone) && ResUtil.getString(R.string.get_auth_code) == codeString
    }

    fun kanGetCodeLogin(phone: String?, codeString: String?, passLogin: Boolean): Boolean {
        return !passLogin && isPhoneNum(phone) && ResUtil.getString(R.string.get_auth_code) == codeString
    }
}