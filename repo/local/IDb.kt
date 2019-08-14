package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message

interface IDb {
    fun getChatList(): LiveData<List<Chat>>
    fun getChat(date: String): LiveData<Chat?>
    fun setMessage(userName: String,
                   url: String,
                   chatDate: String,
                   message: Message,
                   setIdListener: ((id: Long) -> Unit)? = null)
}