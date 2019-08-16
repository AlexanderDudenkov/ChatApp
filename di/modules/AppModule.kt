package com.noosphereglobal.chatapp.di.modules

import com.google.gson.Gson
import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.domain.Interactor
import com.noosphereglobal.chatapp.repo.IRepository
import com.noosphereglobal.chatapp.repo.Repository
import com.noosphereglobal.chatapp.repo.local.IRealmDb
import com.noosphereglobal.chatapp.repo.local.ILocalRepo
import com.noosphereglobal.chatapp.repo.local.RealmDbRepo
import com.noosphereglobal.chatapp.repo.remote.IRemoteRepo
import com.noosphereglobal.chatapp.repo.remote.ISocketService
import com.noosphereglobal.chatapp.repo.remote.OkhttpRepo
import dagger.Module
import dagger.Provides

@Module(includes = [DbModule::class, SocketModule::class, GsonModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideIUseCases(repository: IRepository): IUseCases = Interactor(repository)

    @Provides
    @ApplicationScope
    fun provideIRepository(local: ILocalRepo, remote: IRemoteRepo): IRepository = Repository(local, remote)

    @Provides
    @ApplicationScope
    fun provideILocalRepo(db: IRealmDb): ILocalRepo = RealmDbRepo(db)

    @Provides
    @ApplicationScope
    fun provideIRemoteRepo(service: ISocketService, gson: Gson): IRemoteRepo = OkhttpRepo(service, gson)
}