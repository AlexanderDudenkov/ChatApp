package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.repo.local.IDb
import com.noosphereglobal.chatapp.repo.local.RealmDb
import com.noosphereglobal.chatapp.repo.remote.ISocketService
import com.noosphereglobal.chatapp.repo.remote.SocketService
import dagger.Module
import dagger.Provides

@Module
class SocketModule {

    @Provides
    @ApplicationScope
    fun provideISocketService(): ISocketService = SocketService()
}