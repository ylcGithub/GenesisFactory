package com.dyzn.genesis.module_login.view.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.dyzn.genesis.lib_common.base.BaseViewModel
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.lib_common.widget.SelectedStringPopWindow
import com.dyzn.genesis.module_login.R

/**
 *@author YLC-D
 *@create on 2020/10/27 14
 *说明:
 */
class LoginViewModel : BaseViewModel() {

    val phone = MutableLiveData<String>()
    val pwd = MutableLiveData<String>()
    val securityCode = MutableLiveData<String>()
    val codeString = MutableLiveData(ResUtil.getString(R.string.get_auth_code))
    val pwdLogin = MutableLiveData(true)
    val loginState = MutableLiveData<Boolean>()

    private val repository by lazy {
        LoginRepository(this, viewModelScope)
    }

    fun login(v: View?) {
        repository.login(phone.value!!, pwd.value!!)
    }

    fun getCode(v: View?) {
        repository.getCode()
    }

    fun usePwdLogin(v:View?){
        pwdLogin.value = true
    }

    fun useCodeLogin(v:View?){
        pwdLogin.value = false
    }

    override fun onCleared() {
        super.onCleared()
        repository.cancelTimer()
    }
}