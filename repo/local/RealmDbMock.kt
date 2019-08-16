/*
package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message

class RealmDbMock : IRealmDb {
    private val listChats: LiveData<List<Chat>> =
            MutableLiveData(ArrayList<Chat>().apply {
                add(Chat("url", ArrayList<Message>().apply { add(Message("name1", "text1")) }))
                add(Chat("url", ArrayList<Message>().apply { add(Message("name1", "text1")) }))
            })

    override fun getChatList(): LiveData<List<Chat>> = listChats

    override fun getChat(date: String): LiveData<Chat?> = Transformations.switchMap(listChats as MutableLiveData) {
        MutableLiveData(listChats.value?.last())
    }

    override fun getChat(date: String, chatListener: (chat: Chat?) -> Unit) {
        chatListener(listChats.value?.last())
    }

    override fun setMessage(userName: String, url: String, chatDate: String, message: Message, setIdListener: ((id: Long) -> Unit)?) {
        (listChats as MutableLiveData).postValue(listChats.value?.apply { (this.last().messageList as ArrayList).add(message) })

        setIdListener?.invoke(1L)
    }

    override fun setChat(chat: Chat, setIdListener: ((id: Long) -> Unit)?) {
        (listChats as MutableLiveData).postValue(listChats.value?.apply { (this as ArrayList).add(chat) })

        setIdListener?.invoke(1L)
    }
}*/
