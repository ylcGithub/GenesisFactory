package com.dyzn.genesis.lib_common.common

import android.text.TextWatcher

/**
 *@author YLC-D
 *@create on 2021/2/18 10
 *说明: 取消掉 不常用的方法实现
 */
interface SimpleTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }
}