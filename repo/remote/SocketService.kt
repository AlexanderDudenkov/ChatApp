package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message

class SocketService : ISocketService {
    override fun getChatList(): LiveData<List<Chat>> {
        return MutableLiveData(
                mutableListOf(
                        Chat("1", listOf(Message("name1", "text1"))),
                        Chat("2", listOf(Message("name2", "text2")))
                )
        )
    }

    override fun openChat(url: String): LiveData<String> {
        return MutableLiveData()
    }
}