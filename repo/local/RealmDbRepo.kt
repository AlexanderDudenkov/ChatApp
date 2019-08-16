package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.toChat
import com.noosphereglobal.chatapp.domain.toChatRealm
import com.noosphereglobal.chatapp.domain.toMessageRealm
import com.noosphereglobal.chatapp.repo.local.models.ChatRealm
import javax.inject.Inject

class RealmDbRepo @Inject constructor(override val db: IRealmDb) : ILocalRepo {

    override fun getChatList(): LiveData<List<Chat>> {
        return Transformations.switchMap(RealmResultsLiveData(db.getChatList())) {
            MutableLiveData<List<Chat>>(ArrayList<Chat>().apply {
                it.forEach { chatRealm -> add(chatRealm.toChat()) }
            })
        }
    }

    override fun getChat(date: String): LiveData<Chat?> =
            Transformations.switchMap(RealmModelLiveData(db.getChat(date))) {
                MutableLiveData<Chat?>((it as ChatRealm).toChat())
            }

    override fun getChat(date: String, chatListener: (chat: Chat?) -> Unit) {
        db.getChat(date) { chatListener(it?.toChat()) }
    }

    override fun setMessage(userName: String,
                            url: String,
                            chatDate: String,
                            message: Message,
                            setIdListener: ((id: Long) -> Unit)?) {

        db.setMessage(userName, url, chatDate, message.toMessageRealm(), setIdListener)
    }

    override fun setChat(chat: Chat, setIdListener: ((id: Long) -> Unit)?) {
        db.setChat(chat.toChatRealm(), setIdListener)
    }

    override fun closeDb() {
        db.closeRealm()
    }
}