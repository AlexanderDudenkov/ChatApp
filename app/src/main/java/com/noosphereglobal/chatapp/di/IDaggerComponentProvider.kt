package com.noosphereglobal.chatapp.di

import android.app.Activity
import com.noosphereglobal.chatapp.di.components.IAppComponent

interface IDaggerComponentProvider {
    val component: IAppComponent
}

val Activity.injector get() = (application as IDaggerComponentProvider).component