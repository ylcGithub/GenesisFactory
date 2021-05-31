package com.dyzn.genesis.module_login.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.dyzn.genesis.lib_common.base.BaseActivity
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.util.AppManager
import com.dyzn.genesis.module_login.R

/**
 *@author YLC-D
 *@create on 2020/10/17 17
 *说明:
 */
@Route(path = RoutePath.LOGIN_ACTIVITY_PATH)
class LoginActivity : BaseActivity() {
    override fun getLayoutId() = R.layout.login_activity_main
    lateinit var model: LoginActivityModel
    override fun initData() {
        model = getActivityViewModelProvider(this).get(LoginActivityModel::class.java)
        model.quitApp.observe(this, {
            if (it) {
                AppManager.finishActivity(this)
            }
        })
    }
}