package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import javax.inject.Inject

class RemoteRepo @Inject constructor(override val service: ISocketService) : IRemoteRepo {
    override fun getChatList(): LiveData<List<Chat>> {
        return service.getChatList()
    }

    override fun openChat(url: String): LiveData<String> {
        return service.openChat(url)
    }
}