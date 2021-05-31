package com.dyzn.genesis.module_login.view.register

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyzn.genesis.lib_common.base.BaseViewModel
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.http.LoginApi

/**
 *@author YLC-D
 *@create on 2020/11/20 10
 *说明:
 */

class RegisterViewModel : BaseViewModel() {
    private val repo by lazy {
        RegisterRepository(this,viewModelScope)
    }

    val phone = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val confirmPwd = MutableLiveData<String>()
    val code = MutableLiveData<String>()
    val codeString = MutableLiveData(ResUtil.getString(R.string.get_auth_code))
    val registerSuccess = MutableLiveData<Boolean>()

    fun getAuthCode(v: View) {
        repo.getCode()
    }

    fun register(v: View) {
        repo.register()
    }

    override fun onCleared() {
        super.onCleared()
        repo.cancelTimer()
    }
}