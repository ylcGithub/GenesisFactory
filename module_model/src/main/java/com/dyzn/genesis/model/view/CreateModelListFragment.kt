package com.dyzn.genesis.model.view

import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.model.R
import com.dyzn.genesis.model.databinding.ModelCreatedModelListFragmentBinding
import com.dyzn.genesis.model.model.DiyListViewModel

/**
 *@author YLC-D
 *@create on 2020/12/22 16
 *说明:用户创建的所有模型列表页面
 */
class CreateModelListFragment :BaseFragment<DiyListViewModel,ModelCreatedModelListFragmentBinding>() {
    override fun getViewModel(): DiyListViewModel = getFragmentViewModelProvider(this).get(DiyListViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.model_created_model_list_fragment
    override fun initData() {
        mBinding.vm = mViewModel
    }
}