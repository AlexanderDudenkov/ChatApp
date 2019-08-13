package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.repo.IRepository
import javax.inject.Inject

open class Interactor @Inject constructor(private val repository: IRepository) : IUseCases {

    override fun getChatList(): LiveData<List<Chat>> {
        return repository.localRepo.getChatList()
    }

    override fun openChat(url: String): LiveData<String?> {
        return repository.remoteRepo.openChat(url)
    }

    override fun getChat(date: String): LiveData<Chat> {
        return repository.localRepo.getChat(date)
    }

    override fun sendMessage(mes: String): LiveData<String?> {
        return repository.remoteRepo.sendMessage(mes)
    }

}


