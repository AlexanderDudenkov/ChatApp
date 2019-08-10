package com.noosphereglobal.chatapp.view.adapters

import android.view.View
import android.view.ViewGroup
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.models.Chat
import com.noosphereglobal.chatapp.util.inflate
import com.noosphereglobal.chatapp.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.view.base.BaseViewHolder
import kotlinx.android.synthetic.main.chat_1_item.view.*

open class MainAdapter : BaseRecyclerAdapter<BaseViewHolder<Chat>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Chat> {
        val v = parent.inflate(R.layout.chat_1_item)
        return MainViewHolder(v, onClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Chat>, position: Int) {
        holder.bindData((list as ArrayList<Chat>)[position])
    }
}

open class MainViewHolder(itemView: View, clickedListener: ((Int) -> Unit)? = null)
    : BaseViewHolder<Chat>(itemView, clickedListener) {

    override fun bindData(data: Chat?) {
        itemView.run {
            tv_number_of_messages_chat1_item?.text = data?.messages.toString()
            tv_date_chat1_item?.text = data?.date
        }
    }
}