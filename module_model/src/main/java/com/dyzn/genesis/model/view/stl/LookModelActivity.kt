package com.dyzn.genesis.model.view.stl

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.BounceInterpolator
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.dyzn.genesis.lib_common.base.BaseMvvmActivity
import com.dyzn.genesis.lib_common.bean.mall.GoodsBean
import com.dyzn.genesis.lib_common.config.ParamsKey
import com.dyzn.genesis.lib_common.config.RoutePath
import com.dyzn.genesis.lib_common.expand.toast
import com.dyzn.genesis.lib_common.util.CacheFileUtil
import com.dyzn.genesis.lib_common.util.LogUtil
import com.dyzn.genesis.model.R
import com.dyzn.genesis.model.databinding.ModelLookModelActivityBinding

/**
 *@author YLC-D
 *@create on 2021/1/18 10
 *说明: 查看 STL 格式的 3D 模型 详情页面
 * 使用 openGl 技术
 */
@Route(path = RoutePath.LOOK_MODEL_ACTIVITY_PATH)
class LookModelActivity : BaseMvvmActivity<LookModelViewModel, ModelLookModelActivityBinding>() {
    override fun getViewModel(): LookModelViewModel =
        getActivityViewModelProvider(this).get(LookModelViewModel::class.java)

    @JvmField
    @Autowired(name = ParamsKey.STL_MODEL_ID)
    var stlId = ""

    @JvmField
    @Autowired(name = ParamsKey.STL_MODEL_NAME)
    var stlName = ""

    @JvmField
    @Autowired(name = ParamsKey.GOODS_BEAN)
    var goodsBean: GoodsBean? = null

    override fun getLayoutId(): Int = R.layout.model_look_model_activity

    override fun initData() {
        LogUtil.log("开始时间:${System.currentTimeMillis()}")
        mBinding.vm = mViewModel
        mBinding.click = ClickProxy()
        mViewModel.title.value = stlName
        goodsBean?.let {
            mBinding.buyGoodsTitle.goodsBean = it
            val y = ObjectAnimator.ofFloat(mBinding.buyGoodsTitle, "scaleY", 0f, 1f)
            val x = ObjectAnimator.ofFloat(mBinding.buyGoodsTitle, "scaleX", 0f, 1f)
            val set = AnimatorSet()
            set.addListener(object : Animator.AnimatorListener{
                override fun onAnimationStart(animation: Animator?) {
                    mBinding.buyGoodsTitle.visibility = View.VISIBLE
                    LogUtil.log("动画开始时间1:${System.currentTimeMillis()}")
                }

                override fun onAnimationEnd(animation: Animator?) {

                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationRepeat(animation: Animator?) {
                }

            })
            set.interpolator = BounceInterpolator()
            set.playTogether(x,y)
            set.duration = 600
            set.start()
        }
        if(CacheFileUtil.stlIsInSdCard(stlId)){
            mViewModel.loadModel(CacheFileUtil.getStlInSdCardOfPath(stlId))
        } else {
            mViewModel.downloadStl(stlId)
        }
        mViewModel.model.observe(this, {
            mBinding.stlView.stlRenderer.requestRedraw(it)
        })
        LogUtil.log("结束时间:${System.currentTimeMillis()}")
    }

    override fun onResume() {
        super.onResume()
        mBinding.stlView.onResume()
    }

    inner class ClickProxy {
        fun back() {
            finishActivity()
        }

        fun processing() {
            "加工".toast()
        }

        fun reduction() {
            "还原".toast()
            mBinding.stlView.stlRenderer.reduction()
        }
    }
}