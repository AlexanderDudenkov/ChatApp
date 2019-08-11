package com.noosphereglobal.chatapp.di.modules

import com.noosphereglobal.chatapp.di.scopes.ApplicationScope
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.domain.Interactor
import com.noosphereglobal.chatapp.repo.IRepository
import com.noosphereglobal.chatapp.repo.Repository
import com.noosphereglobal.chatapp.repo.local.IDb
import com.noosphereglobal.chatapp.repo.local.ILocalRepo
import com.noosphereglobal.chatapp.repo.local.LocalRepo
import com.noosphereglobal.chatapp.repo.remote.IRemoteRepo
import com.noosphereglobal.chatapp.repo.remote.ISocketService
import com.noosphereglobal.chatapp.repo.remote.RemoteRepo
import dagger.Module
import dagger.Provides

@Module(includes = [DbModule::class, SocketModule::class])
class AppModule {

    @Provides
    @ApplicationScope
    fun provideIUseCases(repository: IRepository): IUseCases = Interactor(repository)

    @Provides
    @ApplicationScope
    fun provideIRepository(local: ILocalRepo, remote: IRemoteRepo): IRepository = Repository(local, remote)

    @Provides
    @ApplicationScope
    fun provideILocalRepo(db: IDb): ILocalRepo = LocalRepo(db)

    @Provides
    @ApplicationScope
    fun provideIRemoteRepo(service: ISocketService): IRemoteRepo = RemoteRepo(service)
}