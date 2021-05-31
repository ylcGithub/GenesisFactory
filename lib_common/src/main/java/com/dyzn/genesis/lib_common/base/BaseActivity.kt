package com.dyzn.genesis.lib_common.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.util.AppManager

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明:
 */
abstract class BaseActivity : AppCompatActivity(), IView {
    protected var isCreated: Boolean = false
    protected var needSetLayout:Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //解决键盘遮挡输入框的问题
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        AppManager.addActivity(this)
        if (needSetLayout && getLayoutId() != -1) {
            setContentView(getLayoutId())
        }
        isCreated = true
    }

    override fun onResume() {
        super.onResume()
        if(isCreated){
            initData()
            isCreated = false
        }
    }

    private lateinit var mActivityProvider: ViewModelProvider
    protected open fun getActivityViewModelProvider(activity: AppCompatActivity): ViewModelProvider {
        if (!this::mActivityProvider.isInitialized) mActivityProvider = ViewModelProvider(activity)
        return mActivityProvider
    }

    protected open fun toNextActivity(path:String,bundle: Bundle? = null){
        ARouter.getInstance().build(path).with(bundle).navigation()
    }
}