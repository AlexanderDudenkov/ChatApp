package com.noosphereglobal.chatapp.repo.local

import javax.inject.Inject

class LocalRepo @Inject constructor(override val db: IDb) : ILocalRepo