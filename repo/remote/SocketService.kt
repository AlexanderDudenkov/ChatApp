package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.util.d

class SocketService : ISocketService {

    override fun getMessage(): LiveData<String?> {
        return MutableLiveData("Message")
    }

    override fun openChat(url: String): LiveData<String?> {
        return MutableLiveData(null)
    }

    override fun sendMessage(json: String): LiveData<String?> {
        d(json)
        return MutableLiveData(null)
    }
}