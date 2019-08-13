package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface IRemoteRepo {
    val service: ISocketService

    fun openChat(url: String): LiveData<String?>
    fun sendMessage(mes: String): LiveData<String?>
    fun getMessage(): LiveData<Responce?>
}