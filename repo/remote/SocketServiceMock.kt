package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.util.d

class SocketServiceMock : ISocketService {

    override fun getMessage(): LiveData<String?> {
        return MutableLiveData("Message")
    }

    override fun openChat(url: String, setErrorListener: (error: String?) -> Unit) {
        setErrorListener(null)
    }

    override fun sendMessage(json: String, setErrorListener: (error: String?) -> Unit) {
        d(json)
        setErrorListener(null)
    }

    override fun closeChat() {

    }
}