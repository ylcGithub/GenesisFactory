package com.dyzn.genesis.module_login.view.forget

import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.module_login.R
import com.dyzn.genesis.module_login.databinding.LoginForgetFragmentBinding

/**
 *@author YLC-D
 *@create on 2021/5/28 15
 *说明: 找回密码
 */
class ForgetFragment : BaseFragment<ForgetViewModel, LoginForgetFragmentBinding>() {
    override fun getViewModel(): ForgetViewModel =
        getFragmentViewModelProvider(this).get(ForgetViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.login_forget_fragment

    override fun initData() {
        mBinding.vm = mViewModel
    }
}