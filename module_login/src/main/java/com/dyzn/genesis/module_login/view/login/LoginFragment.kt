package com.dyzn.genesis.module_login.view.login

import android.view.View
import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.lib_common.config.EventBusKey
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.lib_common.util.ResUtil
import com.dyzn.genesis.lib_common.widget.AppTextView
import com.dyzn.genesis.lib_common.widget.StarRating
import com.dyzn.genesis.module_login.util.LoginMatchUtil
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.data.bean.LoginRequestBody
import com.dyzn.genesis.module_login.databinding.LoginFragmentBinding
import com.dyzn.genesis.module_login.view.LoginActivityModel
import com.jeremyliao.liveeventbus.LiveEventBus

/**
 *@author YLC-D
 *@create on 2020/10/27 14
 *说明:
 */
class LoginFragment : BaseFragment<LoginViewModel, LoginFragmentBinding>() {

    override fun getViewModel(): LoginViewModel {
        return getFragmentViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun getLayoutId(): Int = R.layout.login_fragment
    override fun initData() {
        mBinding.vm = mViewModel
        mBinding.click = ClickProxy()
        mViewModel.pwdLogin.observe(this, {
            mBinding.tvPassLogin.isSelected = it
            mBinding.tvAuthCodeLogin.isSelected = !it
        })
        mViewModel.securityCode.observe(this, {
            mBinding.etPass.setText(it)
        })
        mViewModel.phone.observe(this, {
            checkLogin()
        })
        mViewModel.pwd.observe(this, { checkLogin() })
        LiveEventBus.get(EventBusKey.REGISTER_SUCCESS,LoginRequestBody::class.java).observe(this,{
            mBinding.etPhone.setText(it.username)
            mBinding.etPass.setText(it.pwd)
        })
    }


    private fun checkLogin() {
        val phoneRight = LoginMatchUtil.isPhoneNum(mViewModel.phone.value)
        val pwdRight =
            if (mViewModel.pwdLogin.value!!) LoginMatchUtil.isPwd(mViewModel.pwd.value) else LoginMatchUtil.isAuthCode(
                mViewModel.pwd.value
            )
        mBinding.btnLogin.isEnabled = phoneRight && pwdRight
    }


    lateinit var lav: LoginActivityModel

    inner class ClickProxy {
        fun back(v: View) {
            lav.quitApp.value = true
        }

        fun forgetPwd(v: View) {
            navigate(R.id.login_to_forget)
        }

        fun register(v: View) {
            navigate(R.id.login_to_register)
        }
    }
}