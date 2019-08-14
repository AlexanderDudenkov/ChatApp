package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.google.gson.Gson
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.messageToSocketServiceModel
import com.noosphereglobal.chatapp.domain.socketServiceModelToMessage
import javax.inject.Inject

class OkhttpRepo @Inject constructor(override val service: ISocketService, private val gson: Gson) : IRemoteRepo {

    override fun openChat(url: String, setErrorListener: (error: String?) -> Unit) {
        service.openChat(url, setErrorListener)
    }

    override fun getMessage(): LiveData<Message?> {
        return Transformations.switchMap(service.getMessage() as MutableLiveData) {
            val responce = gson.fromJson(it, SocketServiceModel::class.java).apply { name = "user" }

            MutableLiveData(responce.socketServiceModelToMessage())
        }
    }

    override fun sendMessage(mes: Message, setErrorListener: (error: String?) -> Unit) {
        val json: String = gson.toJson(mes.messageToSocketServiceModel())
        service.sendMessage(json, setErrorListener)
    }

    override fun closeChat() {
        service.closeChat()
    }
}