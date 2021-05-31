package com.dyzn.genesis.model.view

import android.os.Bundle
import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.lib_common.bean.mall.GoodsBean
import com.dyzn.genesis.lib_common.config.ParamsKey
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.lib_common.util.LogUtil
import com.dyzn.genesis.model.R
import com.dyzn.genesis.model.databinding.ModelCreateSuccessModelListFragmentBinding
import com.dyzn.genesis.model.model.DiyListViewModel

/**
 *@author YLC-D
 *@create on 2020/12/23 17
 *说明:用户创建成功的模型列表页面
 */
class CreateSuccessModelListFragment :
    BaseFragment<DiyListViewModel, ModelCreateSuccessModelListFragmentBinding>() {
    override fun getViewModel(): DiyListViewModel =
        getFragmentViewModelProvider(this).get(DiyListViewModel::class.java)

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
            "打开-创建列表界面".toast()
            val bundle = Bundle()
            bundle.putString(ParamsKey.STL_MODEL_ID,"pig")
            bundle.putString(ParamsKey.STL_MODEL_NAME,"pig")
            bundle.putSerializable(ParamsKey.GOODS_BEAN,GoodsBean(741852963L))
            toNextActivity(RoutePath.LOOK_MODEL_ACTIVITY_PATH,bundle)
        }
    }
}