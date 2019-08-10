package com.noosphereglobal.chatapp.view.base

interface IBaseAdapter {
    var onClickListener: ((pos: Int) -> Unit)?
    fun <M> setList(list: List<M>)
}