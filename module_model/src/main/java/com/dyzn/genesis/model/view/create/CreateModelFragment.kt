package com.dyzn.genesis.model.view.create

import androidx.recyclerview.widget.RecyclerView
import com.dyzn.genesis.lib_common.base.BaseFragment
import com.dyzn.genesis.lib_common.base.BaseTwoLayoutAdapter
import com.dyzn.genesis.lib_common.expand.toDateStr
import com.dyzn.genesis.lib_common.type.ItemType
import com.dyzn.genesis.lib_common.util.GlideUtil
import com.dyzn.genesis.lib_common.widget.LayoutManagerUtil
import com.dyzn.genesis.model.R
import com.dyzn.genesis.model.bean.DiyModelBean
import com.dyzn.genesis.model.databinding.ModelCreateModelListItemBinding
import com.dyzn.genesis.model.databinding.ModelCreateModelListTitleBinding
import com.dyzn.genesis.model.databinding.ModelCreatedModelFragmentBinding
import java.lang.String

/**
 *@author YLC-D
 *@create on 2020/12/22 16
 *说明:用户创建的所有模型列表页面
 */
class CreateModelFragment : BaseFragment<CreateModelViewModel, ModelCreatedModelFragmentBinding>() {
    override fun getViewModel(): CreateModelViewModel =
        getFragmentViewModelProvider(this).get(CreateModelViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.model_created_model_fragment
    override fun initData() {
        mBinding.rcvModel.layoutManager = LayoutManagerUtil.getHorizontal(mContext)
        mBinding.rcvModel.adapter = adapter
        mViewModel.getModelList()
    }

    private val adapter = object :
        BaseTwoLayoutAdapter<DiyModelBean, ModelCreateModelListTitleBinding, ModelCreateModelListItemBinding>(
            R.layout.model_create_model_list_title,
            R.layout.model_create_model_list_item
        ) {

        override fun getItemType(pos: Int): ItemType {
            return if (getItem(pos)?.itemType == 0) ItemType.TWO_TYPE else ItemType.ONE_TYPE
        }

        override fun itemIsSame(oldItem: DiyModelBean, newItem: DiyModelBean): Boolean =
            oldItem == newItem

        override fun onBindOneTypeItem(
            binding: ModelCreateModelListTitleBinding,
            item: DiyModelBean,
            holder: RecyclerView.ViewHolder
        ) {
            binding.tvState.text = String.format(item.missionStateDescription, item.itemCount)
        }

        override fun onBindTwoTypeItem(
            binding: ModelCreateModelListItemBinding,
            item: DiyModelBean,
            holder: RecyclerView.ViewHolder
        ) {
            GlideUtil.load(binding.ivModelThumb,item.goodsimage)
            binding.tvModelName.text = item.goodsname
            binding.tvModelCreateTime.text = item.createAt.toDateStr(" yyyy-MM-dd HH:mm")
        }
    }
}