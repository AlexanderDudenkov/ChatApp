package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface IUseCases {
    fun getChatList(): LiveData<List<Chat>>
    fun openChat(userName: String, url: String, setErrorListener: (error: String?) -> Unit)
    fun getChat(chatDate: String): LiveData<Chat?>
    fun sendMessage(mes: String, setErrorListener: (error: String?) -> Unit)
}