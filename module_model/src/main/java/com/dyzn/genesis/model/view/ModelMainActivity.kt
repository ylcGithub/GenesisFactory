package com.dyzn.genesis.model.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.dyzn.genesis.lib_common.base.BaseActivity
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.model.R

/**
 *@author YLC-D
 *@create on 2020/10/23 14
 *说明:
 */
@Route(path = RoutePath.MODEL_ACTIVITY_PATH)
class ModelMainActivity:BaseActivity() {
    override fun getLayoutId(): Int = R.layout.model_main_activity_layout

    override fun initData() {

    }
}