package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message

interface ILocalRepo {
    val db: IRealmDb

    fun getChatList(): LiveData<List<Chat>>
    fun getChat(date: String): LiveData<Chat?>
    fun getChat(date: String, chatListener: (chat: Chat?) -> Unit)

    fun setMessage(userName: String,
                   url: String,
                   chatDate: String,
                   message: Message,
                   setIdListener: ((id: Long) -> Unit)? = null)

    fun setChat(chat: Chat, setIdListener: ((id: Long) -> Unit)? = null)
    fun closeDb()
}