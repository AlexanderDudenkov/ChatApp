package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface IUseCases {
    fun getChatList(): LiveData<List<Chat>>
    fun openChat(url: String): LiveData<String?>
    fun getChat(date: String): LiveData<Chat>
    fun sendMessage(mes: String): LiveData<String?>
}