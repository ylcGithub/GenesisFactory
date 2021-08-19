package com.dyzn.genesis.model.http

import com.dyzn.genesis.lib_common.network.data.BaseResponse
import com.dyzn.genesis.model.bean.DiyModelBean
import retrofit2.http.GET

/**
 *@author YLC-D
 *@create on 2021/7/8 16
 *说明: 模型模块的接口
 */
interface ModelApi {

    //获取用户的所用自定义模型的列表
    @GET("app/dy_bussness/v1/user/messionList")
    suspend fun getDiyModelList():BaseResponse<List<DiyModelBean>>
}