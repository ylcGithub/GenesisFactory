package com.dyzn.genesis.lib_common.base

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.util.AppManager
import com.dyzn.genesis.lib_common.util.ResUtil
import com.jaeger.library.StatusBarUtil

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明:activity的基类封装
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
            initStatusBar()
            isCreated = false
        }
    }

    protected open fun initStatusBar() {
        StatusBarUtil.setLightMode(this)
        StatusBarUtil.setTranslucent(this, 0)
        StatusBarUtil.setColorNoTranslucent(this, ResUtil.getColor(R.color.white))
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