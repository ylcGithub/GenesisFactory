package com.dyzn.genesis.model.view.stl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyzn.genesis.lib_common.base.BaseViewModel
import com.dyzn.genesis.lib_common.http.FileUpOrDownloadRepository
import com.dyzn.genesis.lib_common.widget.stl.Model

/**
 *@author YLC-D
 *@create on 2021/1/18 11
 *说明:
 */
class LookModelViewModel : BaseViewModel() {
    private val fileRepository: FileUpOrDownloadRepository by lazy {
        FileUpOrDownloadRepository(this,viewModelScope,showProgress,schedule,model)
    }
    val title: MutableLiveData<String> = MutableLiveData("1")
    val model: MutableLiveData<Model> = MutableLiveData()
    val schedule: MutableLiveData<Int> = MutableLiveData()
    val showProgress: MutableLiveData<Boolean> = MutableLiveData(false)

    fun downloadStl(stlId: String) = fileRepository.downloadStl(stlId)

    fun loadModel(path: String)  = fileRepository.loadModel(path)
}