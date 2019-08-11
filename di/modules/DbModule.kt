package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.repo.local.IDb
import com.noosphereglobal.chatapp.repo.local.RealmDb
import dagger.Module
import dagger.Provides

@Module
class DbModule {

    @Provides
    @ApplicationScope
    fun provideIDb(): IDb = RealmDb()
}