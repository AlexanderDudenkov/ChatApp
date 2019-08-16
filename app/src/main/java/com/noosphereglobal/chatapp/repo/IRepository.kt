package com.noosphereglobal.chatapp.repo

import com.noosphereglobal.chatapp.repo.local.ILocalRepo
import com.noosphereglobal.chatapp.repo.remote.IRemoteRepo

interface IRepository {
    val localRepo: ILocalRepo
    val remoteRepo: IRemoteRepo
}
