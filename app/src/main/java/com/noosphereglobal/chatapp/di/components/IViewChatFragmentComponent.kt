package com.noosphereglobal.chatapp.di.components

import com.noosphereglobal.chatapp.di.modules.ViewChatFragmentModule
import com.noosphereglobal.chatapp.di.scopes.FragmentScope
import com.noosphereglobal.chatapp.presentation.view.ViewChatFragment
import dagger.Component

@FragmentScope
@Component(modules = [ViewChatFragmentModule::class], dependencies = [IAppComponent::class])
interface IViewChatFragmentComponent {
    fun inject(fragment: ViewChatFragment)
}