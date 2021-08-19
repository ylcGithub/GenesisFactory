package com.dyzn.genesis.model.view.create

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyzn.genesis.lib_common.base.BaseViewModel
import com.dyzn.genesis.model.bean.DiyModelBean

/**
 *@author YLC-D
 *@create on 2021/6/18 16
 *说明:
 */
class CreateModelViewModel:BaseViewModel() {
    private val repository by lazy {
        CreateModelRepository(this,viewModelScope)
    }
    val list = MutableLiveData<List<DiyModelBean>>()

    fun getModelList() = repository.getModelList()

}