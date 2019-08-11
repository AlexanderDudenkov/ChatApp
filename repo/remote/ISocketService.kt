package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface ISocketService{
    fun getChatList(): LiveData<List<Chat>>
    fun openChat(url: String): LiveData<String>
}