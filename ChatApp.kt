package com.noosphereglobal.chatapp

import android.app.Application
import com.noosphereglobal.chatapp.di.IDaggerComponentProvider
import com.noosphereglobal.chatapp.di.components.DaggerIAppComponent
import com.noosphereglobal.chatapp.di.components.IAppComponent

class ChatApp:Application(), IDaggerComponentProvider {

    override val component: IAppComponent by lazy {
        DaggerIAppComponent.builder().applicationContext(applicationContext).build()
    }

}