package com.noosphereglobal.chatapp.di.modules

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.noosphereglobal.chatapp.di.scopes.FragmentScope
import com.noosphereglobal.chatapp.presentation.view.MainActivity
import com.noosphereglobal.chatapp.presentation.view.adapters.ViewChatAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewChatFragmentModule(private val activity: MainActivity) {

    @Provides
    @FragmentScope
    fun provideFragmentModule(): Context = activity.baseContext

    @Provides
    @FragmentScope
    fun provideLayoutManager(): RecyclerView.LayoutManager = LinearLayoutManager(provideFragmentModule())

    @Provides
    @FragmentScope
    fun provideAdapter(): BaseRecyclerAdapter<BaseViewHolder<Any>> = ViewChatAdapter()
}