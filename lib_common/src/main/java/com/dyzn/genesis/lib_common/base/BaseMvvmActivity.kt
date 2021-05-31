package com.dyzn.genesis.lib_common.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.lib_common.util.AppManager
import com.dyzn.genesis.lib_common.widget.LoadingDialog

/**
 *@author YLC-D
 *@create on 2021/1/18 11
 *说明:
 */
abstract class BaseMvvmActivity<VM : BaseViewModel, B : ViewDataBinding> : BaseActivity(),
    ILoad, IView {
    protected lateinit var mBinding: B
    protected lateinit var mViewModel: VM

    private val dialog: LoadingDialog by lazy {
        LoadingDialog.create(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        needSetLayout = false
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.lifecycleOwner = this
        mViewModel = getViewModel()
        lifecycle.addObserver(mViewModel)

        //用来解析通过ARouter传递的参数，使用 @Autowired 注解
        ARouter.getInstance().inject(this)
    }

    abstract fun getViewModel(): VM

    override fun showLoading(message: String) {
        mViewModel.loadingText.value = message
        mViewModel.setLoadingState(true)
    }

    override fun hideLoading() {
        mViewModel.setLoadingState(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog.dismiss()
        lifecycle.removeObserver(mViewModel)
    }

    fun finishActivity() {
        AppManager.finishActivity(this)
    }

    override fun onResume() {
        if(isCreated){
            loadingInit()
        }
        super.onResume()
    }

    private fun loadingInit(){
        mViewModel.getLoadingState().observe(this, {
            if (it) dialog.show(mViewModel.loadingText.value)
            else dialog.dismiss()
        })
        mViewModel.errorMsg.observe(this,{
            it.toast()
        })
    }
}