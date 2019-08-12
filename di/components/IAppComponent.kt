package com.noosphereglobal.chatapp.di.components

import android.content.Context
import com.noosphereglobal.chatapp.di.modules.AppModule
import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.presentation.view_models.ChatFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.MainFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.ViewChatFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.ViewModelFactory
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [AppModule::class])
interface IAppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(applicationContext: Context): Builder

        fun build(): IAppComponent
    }

    fun mainViewModelFactory(): ViewModelFactory<MainFragmentViewModel>
    fun viewChatViewModelFactory(): ViewModelFactory<ViewChatFragmentViewModel>
    fun chatViewModelFactory(): ViewModelFactory<ChatFragmentViewModel>
}