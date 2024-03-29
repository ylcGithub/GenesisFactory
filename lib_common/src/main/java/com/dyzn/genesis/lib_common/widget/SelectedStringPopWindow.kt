package com.dyzn.genesis.lib_common.widget

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import androidx.recyclerview.widget.RecyclerView
import com.dyzn.genesis.lib_common.R
import com.dyzn.genesis.lib_common.base.BaseCustomPopWindow
import com.dyzn.genesis.lib_common.base.BaseOneLayoutAdapter
import com.dyzn.genesis.lib_common.bean.common.SelectedBean
import com.dyzn.genesis.lib_common.databinding.SelectedStringItemBinding
import com.dyzn.genesis.lib_common.databinding.SelectedStringPopBinding
import com.dyzn.genesis.lib_common.expand.setItemDecoration
import com.dyzn.genesis.lib_common.util.ResUtil

/**
 *@author YLC-D
 *@create on 2021/6/10 10
 *说明:
 */
class SelectedStringPopWindow(context: Context) :
    BaseCustomPopWindow<SelectedStringPopBinding>(context) {

    override fun getRootView(): View {
        return LayoutInflater.from(context).inflate(R.layout.selected_string_pop, null)
    }
    override fun getBind(): SelectedStringPopBinding = SelectedStringPopBinding.bind(contentView)

    override fun init() {
        popupGravity = Gravity.FILL
        mBind?.rcv?.adapter = mAdapter
        mBind?.rcv?.layoutManager = LayoutManagerUtil.getVertical(context)
        mBind?.rcv?.setItemDecoration(CustomItemDecoration(CustomItemDecoration.Type.VER,ResUtil.getColor(R.color.color_999)).also {
            it.space = 4
        })
        val list = mutableListOf<SelectedBean>()
        for (i in 0..10) {
            list.add(SelectedBean("title-$i", false))
        }
        mAdapter.updateList(list)
    }

    override fun onCreateShowAnimation(): Animation {
        return createVerticalAnimation(-1f,0f)
    }

    override fun onCreateDismissAnimation(): Animation {
        return createVerticalAnimation(0f,-1f)
    }

    private val mAdapter = object :
        BaseOneLayoutAdapter<SelectedBean, SelectedStringItemBinding>(R.layout.selected_string_item) {
        override fun itemIsSame(oldItem: SelectedBean, newItem: SelectedBean): Boolean =
            oldItem == newItem

        override fun onBindOneTypeItem(
            binding: SelectedStringItemBinding,
            item: SelectedBean,
            holder: RecyclerView.ViewHolder
        ) {
            binding.item.setOnClickListener {
                clearSelected()
                dataList[holder.adapterPosition].selected = true
                notifyDataSetChanged()
            }
            binding.title.text = item.title
            binding.ivSelected.visibility = if (item.selected) View.VISIBLE else View.GONE
        }

        private fun clearSelected() {
            val count = itemCount
            for (i in 0 until count) {
                getItem(i)?.selected = false
            }
        }
    }
    var title: String? = null
}