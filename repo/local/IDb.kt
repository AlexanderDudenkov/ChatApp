package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat

interface IDb {
    fun getChatList(): LiveData<List<Chat>>
    fun getChat(date: String): LiveData<Chat>
}