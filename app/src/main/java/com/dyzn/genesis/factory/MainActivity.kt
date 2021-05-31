package com.dyzn.genesis.factory

import android.widget.FrameLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyzn.genesis.lib_common.base.BaseActivity
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.util.LogUtil
import com.dyzn.genesis.lib_common.widget.AnimBgView
import com.jaeger.library.StatusBarUtil
import kotlinx.coroutines.runBlocking

@Route(path = RoutePath.MAIN_ACTIVITY)
class MainActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initData() {
        test("是大佬开发","塑料袋咖啡机")
        val f: FrameLayout = findViewById(android.R.id.content)
        f.addView(AnimBgView(this))
        StatusBarUtil.setTranslucentForImageView(this, 0, null)
        StatusBarUtil.setLightMode(this)
    }

    fun test(str: String, add: String) = runBlocking {
        for (i in 0..30) {
            LogUtil.log("$str --- $add::::$i")
            Thread.sleep(100)
        }
    }
}