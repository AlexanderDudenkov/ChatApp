package com.noosphereglobal.chatapp.view.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T : BaseViewHolder<*>> : RecyclerView.Adapter<T>(),IBaseAdapter