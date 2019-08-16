package com.noosphereglobal.chatapp.repo.local

import com.noosphereglobal.chatapp.repo.local.models.ChatRealm
import com.noosphereglobal.chatapp.repo.local.models.MessageRealm
import io.realm.RealmResults

interface IRealmDb {
    fun getChatList(): RealmResults<ChatRealm>
    fun getChat(date: String): ChatRealm?
    fun getChat(date: String, chatListener: (chat: ChatRealm?) -> Unit)

    fun setMessage(userName: String,
                   url: String,
                   chatDate: String,
                   message: MessageRealm,
                   setIdListener: ((id: Long) -> Unit)? = null)

    fun setChat(chat: ChatRealm, setIdListener: ((id: Long) -> Unit)? = null)
    fun closeRealm()
}