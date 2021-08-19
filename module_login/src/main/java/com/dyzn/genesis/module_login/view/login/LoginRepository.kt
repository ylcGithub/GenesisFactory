package com.dyzn.genesis.module_login.view.login

import android.os.CountDownTimer
import com.dyzn.genesis.lib_common.base.BaseRepository
import com.dyzn.genesis.lib_common.config.HawkKey
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.lib_common.network.HttpFactory
import com.dyzn.genesis.lib_common.util.Md5Util
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.data.bean.LoginRequestBody
import com.dyzn.genesis.module_login.http.LoginApi
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.CoroutineScope

/**
 *@author YLC-D
 *@create on 2020/11/10 17
 *说明:
 */
class LoginRepository(private val viewModel: LoginViewModel, scope: CoroutineScope) :
    BaseRepository(viewModel, scope) {
    private val loginApi by lazy {
        HttpFactory.create(LoginApi::class.java)
    }


    fun login(phone: String, pwd: String) = accessNetwork(
        work = {
            val login = request {
                loginApi.loginAsync(LoginRequestBody(phone, Md5Util.decodeToBit32(pwd)))
            }
            login?.let {
                Hawk.put(HawkKey.USER_PHONE, phone)
                Hawk.put(HawkKey.USER_PASSWORD, pwd)
                Hawk.put(HawkKey.TOKEN, it.token)
                Hawk.put(HawkKey.USER_ID, it.user.id)
                ResUtil.getString(R.string.login_success).toast()
            }
        }
    )

    fun getCode() = accessNetwork(
        work = {
            val code = request { loginApi.getCode(viewModel.phone.value!!) }
            code?.let {
                viewModel.securityCode.value = it
                startTimer()
            }
        }
    )

    private var timer: CountDownTimer?=null
    private fun startTimer(){
        timer = object: CountDownTimer(60*1000L,1000L){
            override fun onTick(millisUntilFinished: Long) {
                viewModel.setValueOnMain(viewModel.codeString,"${millisUntilFinished/1000}(s)")
            }

            override fun onFinish() {
                viewModel.setValueOnMain(viewModel.codeString,ResUtil.getString(R.string.get_auth_code))
            }
        }
        timer?.start()
    }
    fun cancelTimer(){
        timer?.cancel()
    }
}