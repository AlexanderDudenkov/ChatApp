package com.noosphereglobal.chatapp.presentation.view.adapters

import android.view.View
import android.view.ViewGroup
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.util.inflate
import com.noosphereglobal.chatapp.presentation.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseViewHolder
import kotlinx.android.synthetic.main.main_chat_item.view.*

open class MainAdapter : BaseRecyclerAdapter<BaseViewHolder<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        val v = parent.inflate(R.layout.main_chat_item)
        return MainViewHolder(v, onClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.bindData(list[position])
    }
}

open class MainViewHolder(itemView: View, clickedListener: ((Int) -> Unit)? = null)
    : BaseViewHolder<Any>(itemView, clickedListener) {

    override fun bindData(data: Any?) {
        itemView.run {
            tv_date_chat1_item?.text = (data as? Chat)?.date
        }
    }
}