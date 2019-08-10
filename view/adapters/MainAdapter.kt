package com.noosphereglobal.chatapp.view.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.noosphereglobal.chatapp.models.Chat
import com.noosphereglobal.chatapp.util.d
import com.noosphereglobal.chatapp.view.base.ABaseAdapter
import com.noosphereglobal.chatapp.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.view.base.BaseViewHolder

class MainAdapter : BaseRecyclerAdapter<BaseViewHolder<Chat>>() {

    override var onClickListener: ((pos: Int) -> Unit)? = null

    override fun <M> setList(list: List<M>) {
        d("setList; ${list.size}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Chat> {
        val v = TextView(parent.context).apply { text = "item" }
        return MainViewHolder(v, onClickListener)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder<Chat>, position: Int) {
    }

}

class MainViewHolder(itemView: View, clickedListener: ((Int) -> Unit)? = null)
    : BaseViewHolder<Chat>(itemView, clickedListener) {

    override fun bindData(data: Chat?) {

    }

}