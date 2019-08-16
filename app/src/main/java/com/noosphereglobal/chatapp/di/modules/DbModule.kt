package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.presentation.ChatApp
import com.noosphereglobal.chatapp.repo.local.IRealmDb
import com.noosphereglobal.chatapp.repo.local.RealmDb
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration

@Module
class DbModule {

    @Provides
    @ApplicationScope
    fun provideIDb(realm: Realm): IRealmDb = RealmDb(realm)

    @Provides
    @ApplicationScope
    fun provideRealmConfiguration():RealmConfiguration {
        Realm.init(ChatApp.getInstance())
        return RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("realm.realm")
                .build()
    }

    @Provides
    @ApplicationScope
    fun provideRealm(config: RealmConfiguration): Realm = Realm.getInstance(config)
}
