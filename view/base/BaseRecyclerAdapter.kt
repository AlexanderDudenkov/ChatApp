package com.noosphereglobal.chatapp.view.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T : BaseViewHolder<*>> : RecyclerView.Adapter<T>(), IBaseAdapter {

    override var onClickListener: ((pos: Int) -> Unit)? = null

    val list: ArrayList<Any> = ArrayList()

    override fun getItemCount(): Int {
        return list.size
    }

    override fun setList(list: List<Any>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}