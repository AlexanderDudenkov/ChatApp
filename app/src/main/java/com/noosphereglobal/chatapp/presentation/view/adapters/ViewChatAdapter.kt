package com.noosphereglobal.chatapp.presentation.view.adapters

import android.view.View
import android.view.ViewGroup
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.util.inflate
import com.noosphereglobal.chatapp.presentation.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseViewHolder
import kotlinx.android.synthetic.main.chat_item.view.*

open class ViewChatAdapter : BaseRecyclerAdapter<BaseViewHolder<Any>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Any> {
        val v = parent.inflate(R.layout.chat_item)
        return ViewChatHolder(v, onClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Any>, position: Int) {
        holder.bindData(list[position])
    }
}

open class ViewChatHolder(itemView: View, clickedListener: ((Int) -> Unit)? = null)
    : BaseViewHolder<Any>(itemView, clickedListener) {

    override fun bindData(data: Any?) {
        itemView.run {
            tv_name_chat_item?.text = (data as? Message)?.name
            tv_message_chat_item?.text = (data as? Message)?.text
            tv_time_chat_item?.text = (data as? Message)?.time
        }
    }
}