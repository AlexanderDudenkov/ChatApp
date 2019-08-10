package com.noosphereglobal.chatapp.view.base

import androidx.annotation.IdRes

interface INavigation {
    fun navigate(@IdRes fragmentId: Int)
}