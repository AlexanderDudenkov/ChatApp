package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.noosphereglobal.chatapp.data.Message
import javax.inject.Inject

class OkhttpRepo @Inject constructor(override val service: ISocketService) : IRemoteRepo {

    override fun openChat(url: String, setErrorListener: (error: String?) -> Unit) {
        service.openChat(url,setErrorListener)
    }

    override fun getMessage(): LiveData<Message?> {
        return Transformations.switchMap(service.getMessage() as MutableLiveData) {
            //Gson.json to obj
            MutableLiveData(Message("user", "text"))
        }
    }

    override fun sendMessage(mes: Message, setErrorListener: (error: String?) -> Unit) {
        service.sendMessage(mes.text, setErrorListener)
    }
}