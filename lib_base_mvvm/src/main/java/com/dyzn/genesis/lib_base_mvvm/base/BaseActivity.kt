package com.dyzn.genesis.lib_base_mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *@author YLC-D
 *@create on 2020/10/20 15
 *说明:
 */
abstract class BaseActivity:AppCompatActivity(),IView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

}