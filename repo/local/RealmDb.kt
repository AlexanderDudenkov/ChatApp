package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message

class RealmDb : IDb {
    override fun getChatList(): LiveData<List<Chat>> = MutableLiveData()
    override fun getChat(date: String): LiveData<Chat> = MutableLiveData(
            Chat("",
                    listOf(Message("name1", "text1"),
                            Message("name1", "text1"),
                            Message("name1", "text1")
                    )
            )
    )
}