package com.dyzn.genesis.module_login.http

import com.dyzn.genesis.lib_common.network.data.BaseResponse
import com.dyzn.genesis.module_login.data.bean.LoginRequestBody
import com.dyzn.genesis.module_login.data.bean.UserBody
import kotlinx.coroutines.Deferred
import retrofit2.http.*

/**
 *@author YLC-D
 *@create on 2020/11/2 16
 *说明: 登录模块的网络接口API
 */
interface LoginApi {
    /**
     * 登录接口
     * suspend 表示只能在协程中访问
     * @param body 账号电话  登录验证码 密码
     * @return 用户信息
     */
    @POST("app/auth/v1/login")
    suspend fun loginAsync(@Body body: LoginRequestBody): BaseResponse<UserBody>

    @GET("app/user_bussness/v1/user/getRegisterSms")
    suspend fun getCode(@Query("phone") phone:String):BaseResponse<String>

    @FormUrlEncoded
    @POST("app/user_bussness/v1/user/register")
    suspend fun register(@Field("phone") phone:String,@Field("code") code:String,@Field("pwd") pwd:String):BaseResponse<Any>

    @FormUrlEncoded
    @POST("app/user_bussness/v1/user/resetPWD")
    suspend fun findPwd(@Field("phone") phone:String,@Field("code") code:String,@Field("pwd") pwd:String):BaseResponse<String>
}