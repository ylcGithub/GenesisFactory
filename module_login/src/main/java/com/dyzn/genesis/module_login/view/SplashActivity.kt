package com.dyzn.genesis.module_login.view

import android.os.Bundle
import com.dyzn.genesis.lib_common.base.BaseActivity
import com.dyzn.genesis.lib_common.config.HawkKey.USER_PASSWORD
import com.dyzn.genesis.lib_common.config.HawkKey.USER_PHONE
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.util.AppManager
import com.dyzn.genesis.lib_common.util.CacheFileUtil
import com.dyzn.genesis.module_login.util.LoginMatchUtil
import com.dyzn.genesis.lib_common.widget.LoadingDialog
import com.dyzn.genesis.module_login.view.login.LoginViewModel
import com.jaeger.library.StatusBarUtil
import com.orhanobut.hawk.Hawk

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明:
 */
class SplashActivity : BaseActivity() {

    override fun getLayoutId(): Int = -1
    private val dialog:LoadingDialog by lazy {
        LoadingDialog.create(this)
    }
    lateinit var vm: LoginViewModel

    override fun initData() {
        CacheFileUtil.deleteLocalLog()
        StatusBarUtil.setTranslucentForImageView(this, 0, null)
        vm = getActivityViewModelProvider(this).get(LoginViewModel::class.java)

        val phone = Hawk.get(USER_PHONE, "")
        val pass = Hawk.get(USER_PASSWORD, "")
        if (LoginMatchUtil.isPhoneNum(phone) && LoginMatchUtil.isPwd(pass)) {
            vm.phone.value = phone
            vm.pwd.value = pass
            vm.login(null)
        } else {
            toNextActivity(RoutePath.LOGIN_ACTIVITY_PATH)
        }
        vm.getLoadingState().observe(this,{
            if(it){
                dialog.show()
            }else{
                dialog.dismiss()
            }
        })
        vm.loginState.observe(this,{
            if(it){
                toNextActivity(RoutePath.MAIN_ACTIVITY)
            }else{
                toNextActivity(RoutePath.LOGIN_ACTIVITY_PATH)
            }
        })
    }

    override fun toNextActivity(path: String, bundle: Bundle?) {
        super.toNextActivity(path, bundle)
        AppManager.finishActivity(this)
    }
} 