package com.dyzn.genesis.module_login.view.forget

import android.os.CountDownTimer
import com.dyzn.genesis.lib_common.base.BaseRepository
import com.dyzn.genesis.lib_common.config.EventBusKey
import com.dyzn.genesis.lib_common.config.HawkKey
import com.dyzn.genesis.lib_common.network.HttpFactory
import com.dyzn.genesis.lib_common.util.Md5Util
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.data.bean.LoginRequestBody
import com.dyzn.genesis.module_login.http.LoginApi
import com.jeremyliao.liveeventbus.LiveEventBus
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.CoroutineScope

/**
 *@author YLC-D
 *@create on 2021/5/28 14
 *说明:
 */
class ForgetRepository(val viewModel: ForgetViewModel,scope: CoroutineScope): BaseRepository(viewModel,scope){
    private val api by lazy {
        HttpFactory.create(LoginApi::class.java)
    }

    fun findPwd() = accessNetwork(
        work = {
            val phone = viewModel.phone.value!!
            val pwd = viewModel.pwd.value!!
            val res = request { api.findPwd(phone,viewModel.code.value!!,Md5Util.decodeToBit32(pwd)) }
            Hawk.put(HawkKey.USER_PASSWORD,pwd)
            LiveEventBus.get(EventBusKey.REGISTER_SUCCESS).postDelay(LoginRequestBody(phone,pwd),1000)
            viewModel.back()
        }
    )

    fun getCode() = accessNetwork(
        work = {
            val code = request { api.getCode(viewModel.phone.value!!) }
            code?.let {
                viewModel.code.value = it
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
                viewModel.setValueOnMain(viewModel.codeString, ResUtil.getString(R.string.get_auth_code))
            }
        }
        timer?.start()
    }
    fun cancelTimer(){
        timer?.cancel()
    }
}