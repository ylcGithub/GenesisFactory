package com.dyzn.genesis.model.view.createsuccess

import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.model.R
import com.dyzn.genesis.model.databinding.ModelCreateSuccessModelListFragmentBinding

/**
 *@author YLC-D
 *@create on 2020/12/23 17
 *说明:用户创建成功的模型列表页面
 */
class CreateSuccessModelListFragment :
    BaseFragment<CreateSuccessViewModel, ModelCreateSuccessModelListFragmentBinding>() {
    override fun getViewModel(): CreateSuccessViewModel =
        getFragmentViewModelProvider(this).get(CreateSuccessViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.model_create_success_model_list_fragment

    override fun initData() {
        mBinding.vm = mViewModel
        mBinding.click = ClickProxy()
    }

    inner class ClickProxy {
        fun back() {
            pageBack()
        }

        fun clickMessage() {
            "打开消息页面".toast()
        }

        fun clickRightTwo() {
            navigate(R.id.create_model)
        }
    }
}