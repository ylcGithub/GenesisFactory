package com.dyzn.genesis.lib_common.common

import android.text.Editable
import android.view.View
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.dyzn.genesis.lib_common.widget.AppTitle
import com.dyzn.genesis.lib_common.widget.AppProgressView
import com.dyzn.genesis.lib_common.widget.stl.Model
import com.dyzn.genesis.lib_common.widget.stl.StlView

/**
 *@author YLC-D
 *@create on 2020/12/9 11
 *说明:
 */
// AppTitle 适配dataBinding的方法
@BindingAdapter("titleBackListener")
fun setAppTitleBackListener(appTitle: AppTitle, listener: View.OnClickListener) {
    appTitle.setClickBackListener(listener)
}

@BindingAdapter("titleOneIconListener")
fun setAppTitleRightOneIconListener(appTitle: AppTitle, listener: View.OnClickListener) {
    appTitle.setRightOneImageBtnClickListener(listener)
}

@BindingAdapter("titleTwoIconListener")
fun setAppTitleRightTwoIconListener(appTitle: AppTitle, listener: View.OnClickListener) {
    appTitle.setRightTwoImageBtnClickListener(listener)
}

@BindingAdapter("titleOneTextListener")
fun setAppTitleRightOneTextListener(appTitle: AppTitle, listener: View.OnClickListener) {
    appTitle.setRightOneTextBtnClickListener(listener)
}

@BindingAdapter("titleTwoTextListener")
fun setAppTitleRightTwoTextListener(appTitle: AppTitle, listener: View.OnClickListener) {
    appTitle.setRightTwoTextBtnClickListener(listener)
}

@BindingAdapter("setTitle")
fun setAppTitleTitle(appTitle: AppTitle, tile: String?) {
    appTitle.setTitle(tile)
}
//AppEditText

@BindingAdapter("editTextChange")
fun editTextChange(et: EditText, value: MutableLiveData<String>?) {
    et.addTextChangedListener(object :SimpleTextWatcher{
        override fun afterTextChanged(s: Editable?) {
            value?.value = s.toString()
        }
    })
}



// stlView 的适配方法
@BindingAdapter("bindModel")
fun setStlViewModel(stlView: StlView, model: Model?) {
    stlView.stlRenderer.requestRedraw(model)
}
//进度控件的适配方法
@BindingAdapter("schedule")
fun setProgressViewSchedule(view:AppProgressView, schedule:Int){
    view.setSchedule(schedule)
}
@BindingAdapter("progressHintText")
fun setProgressViewHintText(view:AppProgressView, hintText:String?){
    view.setShowText(hintText)
}