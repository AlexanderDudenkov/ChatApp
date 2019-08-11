package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface IUseCases {
    fun getChatList(): LiveData<List<Chat>>
    fun openChat(url: String): LiveData<String>
   // fun getChatList(): LiveData<List<Chat>>
}