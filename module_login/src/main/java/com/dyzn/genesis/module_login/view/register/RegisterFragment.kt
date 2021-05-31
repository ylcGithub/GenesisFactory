package com.dyzn.genesis.module_login.view.register


import android.os.Bundle
import android.view.View
import com.dyzn.genesis.lib_common.annotation.arguments.ArgumentsParse
import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.databinding.LoginRegisterFragmentBinding

/**
 *@author YLC-D
 *@create on 2020/11/20 10
 *说明:
 */
class RegisterFragment : BaseFragment<RegisterViewModel, LoginRegisterFragmentBinding>() {
    override fun getViewModel(): RegisterViewModel =
        getFragmentViewModelProvider(this).get(RegisterViewModel::class.java)


    override fun getLayoutId(): Int = R.layout.login_register_fragment

    override fun initData() {
        mBinding.vm = mViewModel
        mBinding.click = ClickProxy()
        mViewModel.registerSuccess.observe(this,{
            pageBack()
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ArgumentsParse.injectParams(this)
    }

    inner class ClickProxy{
        fun back(){
            pageBack()
        }

        fun deletePhone(v: View){
            mBinding.etPhone.setText("")
        }

        fun deletePwd1(v:View){
            mBinding.etPassword.setText("")
        }
        fun deletePwd2(v:View){
            mBinding.etConfirmNewPassword.setText("")
        }
    }
}
