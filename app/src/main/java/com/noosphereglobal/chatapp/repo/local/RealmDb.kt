package com.noosphereglobal.chatapp.repo.local

import com.noosphereglobal.chatapp.repo.local.models.ChatRealm
import com.noosphereglobal.chatapp.repo.local.models.MessageRealm
import com.noosphereglobal.chatapp.util.d
import io.realm.Realm
import io.realm.RealmResults
import javax.inject.Inject

class RealmDb @Inject constructor(val realm: Realm) : IRealmDb {

    override fun getChatList(): RealmResults<ChatRealm> {
        return realm.where(ChatRealm::class.java).findAll()
    }

    override fun getChat(date: String): ChatRealm? {
        return realm.where(ChatRealm::class.java).equalTo("date", date).findFirst()
    }

    override fun getChat(date: String, chatListener: (chat: ChatRealm?) -> Unit) {
        with(getChat(date)) {
            if (this != null) chatListener(realm.copyFromRealm(this)) else chatListener(null)
        }
    }

    override fun setMessage(userName: String,
                            url: String,
                            chatDate: String,
                            message: MessageRealm,
                            setIdListener: ((id: Long) -> Unit)?) {

        realm.executeTransactionAsync(Realm.Transaction {
            val chat = it.where(ChatRealm::class.java)
                    .equalTo("date", chatDate)
                    .equalTo("socketUrl", url)
                    .findFirst()

            chat?.messageList?.add(message)
        },
                Realm.Transaction.OnSuccess {
                    val chat = realm.where(ChatRealm::class.java)
                            .equalTo("date", chatDate)
                            .equalTo("socketUrl", url)
                            .findFirst()

                    setIdListener?.invoke(chat?.messageList?.last()?.id ?: 0L)
                })
    }

    override fun setChat(chat: ChatRealm, setIdListener: ((id: Long) -> Unit)?) {
        realm.executeTransaction {
            it.copyToRealm(chat).apply {
                setIdListener?.invoke(this?.id ?: 0L)
            }
        }
    }

    override fun closeRealm() {
        if (!realm.isClosed && !realm.isInTransaction) {
            realm.close()
        }
    }
}