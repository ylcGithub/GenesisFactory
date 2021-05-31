package com.dyzn.genesis.module_login.view.forget

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyzn.genesis.lib_common.base.BaseViewModel
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.module_login.R

/**
 *@author YLC-D
 *@create on 2021/5/28 14
 *说明:
 */
class ForgetViewModel :BaseViewModel(){
    private val repository by lazy {
        ForgetRepository(this,viewModelScope)
    }
    val phone=MutableLiveData<String>()
    val code=MutableLiveData<String>()
    val codeString=MutableLiveData(ResUtil.getString(R.string.get_auth_code))
    val pwd=MutableLiveData<String>()
    val conPwd=MutableLiveData<String>()

    fun getAuthCode(v: View){
        repository.getCode()
    }

    fun findPwd(v:View) {
        repository.findPwd()
    }
}