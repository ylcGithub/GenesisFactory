package com.dyzn.genesis.model.view.create

import com.dyzn.genesis.lib_common.base.BaseRepository
import com.dyzn.genesis.lib_common.network.HttpFactory
import com.dyzn.genesis.model.http.ModelApi
import kotlinx.coroutines.CoroutineScope

/**
 *@author YLC-D
 *@create on 2021/6/18 16
 *说明:
 */
class CreateModelRepository(private val viewModel: CreateModelViewModel, scope: CoroutineScope):BaseRepository(viewModel,scope) {

    private val api by lazy {
        HttpFactory.create(ModelApi::class.java)
    }

    fun getModelList() =  accessNetwork(work = {
        val result = request { api.getDiyModelList() }
        viewModel.list.postValue(result)
    })

}