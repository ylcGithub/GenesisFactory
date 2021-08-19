package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.alibaba.android.arouter.launcher.ARouter
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.bean.mall.GoodsBean
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.databinding.BuyGoodsBottomTitleLayoutBinding
import com.dyzn.genesis.lib_common.expand.toast

/**
 *@author YLC-D
 *@create on 2021/1/19 10
 *说明:
 */
class BuyGoodsBottomTitle @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), View.OnClickListener {

    private val bind = BuyGoodsBottomTitleLayoutBinding.inflate(LayoutInflater.from(context),this,true)

    init {
        inflate(context, R.layout.buy_goods_bottom_title_layout, this)
        bind.ivCustomerService.setOnClickListener(this)
        bind.ivCart.setOnClickListener(this)
        bind.tvAddToCart.setOnClickListener(this)
        bind.tvBuyNow.setOnClickListener(this)
    }

    var goodsBean:GoodsBean? = null

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_customer_service -> {
                toActivity(RoutePath.CUSTOMER_SERVICE_ACTIVITY_PATH)
            }
            R.id.iv_cart -> {
                toActivity(RoutePath.SHOPPING_CART_ACTIVITY_PATH)
            }
            R.id.tv_add_to_cart -> {
                "把商品添加到购物车中".toast()
            }
            R.id.tv_buy_now -> {
                "弹出购买窗口".toast()
            }
        }
    }

    private fun toActivity(path:String){
        ARouter.getInstance().build(path).navigation()
    }
}