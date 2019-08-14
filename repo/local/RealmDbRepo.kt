package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import javax.inject.Inject

class RealmDbRepo @Inject constructor(override val db: IDb) : ILocalRepo {

    override fun getChatList(): LiveData<List<Chat>> = db.getChatList()

    override fun getChat(date: String): LiveData<Chat?> = db.getChat(date)

    override fun setMessage(userName: String,
                            url: String,
                            chatDate: String,
                            message: Message,
                            setIdListener: ((id: Long) -> Unit)?) {

        db.setMessage(userName, url, chatDate, message, setIdListener)
    }
}