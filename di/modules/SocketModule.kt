package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.repo.remote.ISocketService
import com.noosphereglobal.chatapp.repo.remote.SocketServiceMock
import dagger.Module
import dagger.Provides

@Module
class SocketModule {

    @Provides
    @ApplicationScope
    fun provideISocketService(): ISocketService = SocketServiceMock()
}