package com.noosphereglobal.chatapp.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class GsonModule {
    @Provides
    @ApplicationScope
    fun provideGson(builder: GsonBuilder): Gson = builder.setLenient().create()

    @Provides
    @ApplicationScope
    fun provideGsonBuilder(): GsonBuilder = GsonBuilder()
}