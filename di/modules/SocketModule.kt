package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.BuildConfig
import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.repo.remote.ISocketService
import com.noosphereglobal.chatapp.repo.remote.SocketService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class SocketModule {

    @Provides
    @ApplicationScope
    fun provideISocketService(client: OkHttpClient): ISocketService = SocketService(client)

    @Provides
    @ApplicationScope
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
            OkHttpClient.Builder().apply {
                retryOnConnectionFailure(true)
                networkInterceptors().add(interceptor)
            }.build()

    @Provides
    @ApplicationScope
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }
}