package com.noosphereglobal.chatapp.view.base

interface IBaseAdapter {
    var onClickListener: ((pos: Int) -> Unit)?
    fun setList(list: List<Any>)
}