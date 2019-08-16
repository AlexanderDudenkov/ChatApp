package com.noosphereglobal.chatapp.repo

import com.noosphereglobal.chatapp.repo.local.ILocalRepo
import com.noosphereglobal.chatapp.repo.remote.IRemoteRepo
import javax.inject.Inject

class Repository @Inject constructor(override val localRepo: ILocalRepo,
                                     override val remoteRepo: IRemoteRepo) : IRepository