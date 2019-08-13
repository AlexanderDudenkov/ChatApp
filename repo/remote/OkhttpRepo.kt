package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import javax.inject.Inject

class OkhttpRepo @Inject constructor(override val service: ISocketService) : IRemoteRepo {

    private var url: String? = null

    override fun sendMessage(mes: String): LiveData<String?> = service.sendMessage(mes)

    override fun openChat(url: String): LiveData<String?> {
        this.url = url
        return service.openChat(url)
    }

    override fun getMessage(): LiveData<Responce?> {
        return Transformations.switchMap(service.getMessage() as MutableLiveData) {
            //Gson.json to obj
            MutableLiveData(Responce("user", "text"))
        }
    }
}