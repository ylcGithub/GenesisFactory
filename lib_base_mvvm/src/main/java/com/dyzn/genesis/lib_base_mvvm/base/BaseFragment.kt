package com.dyzn.genesis.lib_base_mvvm.base

import android.content.Context
import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.dyzn.genesis.lib_base_mvvm.widget.LoadingDialog
import java.lang.Exception

/**
 *@author YLC-D
 *@create on 2020/10/22 17
 *说明:
 */
abstract class BaseFragment<B : ViewDataBinding> :Fragment() ,ILoad,IView{
    //上下文
    protected lateinit var mContext: Context
    protected lateinit var mBinding: B
    //数据是否加载标识
    private var isDataInitiated = false
    //view是否加载标识
    private var isViewInitiated = false
    //fragment是否显示
    private var isVisibleToUser = false

    private val dialog: LoadingDialog by lazy {
        LoadingDialog.create(mContext)
    }

    /**
     * 是否懒加载
     * true:是
     * false:不(默认)
     */
    protected open fun lazyLoad() = true

    /**
     * 是否fragment显示的时候都重新加载数据
     */
    protected open fun reLoad() = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mContext = activity?:throw Exception("activity is null from ${javaClass.simpleName}")
        initView()
        //判断是否懒加载
        if (lazyLoad()) {
            //将view加载的标识设置为true
            isViewInitiated = true
            prepareData()
        } else {
            initData()
        }
    }

    /**
     * 懒加载的方法
     */
    private fun prepareData() {
        //通过判断各种标识去进行数据加载
        if (isVisibleToUser && isViewInitiated && !isDataInitiated) {
            initData()
            if (reLoad()) return
            isDataInitiated = true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun showLoading(message: String) {
        dialog.show(message)
    }

    override fun hideLoading() {
        dialog.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        dialog.dismiss()
    }
}