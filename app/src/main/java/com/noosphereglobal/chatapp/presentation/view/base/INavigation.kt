package com.noosphereglobal.chatapp.presentation.view.base

import androidx.annotation.IdRes

interface INavigation {
    fun navigate(@IdRes fragmentId: Int)
}