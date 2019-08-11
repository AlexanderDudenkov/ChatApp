package com.noosphereglobal.chatapp.di.components

import com.noosphereglobal.chatapp.di.modules.MainFragmentModule
import com.noosphereglobal.chatapp.di.scopes.FragmentScope
import com.noosphereglobal.chatapp.presentation.view.MainFragment
import dagger.Component

@FragmentScope
@Component(modules = [MainFragmentModule::class], dependencies = [IAppComponent::class])
interface IMainFragmentComponent {
    fun inject(mainFragment: MainFragment)
}