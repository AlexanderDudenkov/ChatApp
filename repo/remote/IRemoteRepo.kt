package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Message

interface IRemoteRepo {
    val service: ISocketService

    fun openChat(url: String, setErrorListener: (error: String?) -> Unit)
    fun sendMessage(mes: Message,setErrorListener: (error: String?) -> Unit)
    fun getMessage(): LiveData<Message?>
}