package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.repo.IRepository
import javax.inject.Inject

open class Interactor @Inject constructor(private val repository: IRepository) : IUseCases {

    override fun getChatList(): LiveData<List<Chat>> {
        return repository.remoteRepo.getChatList()
    }

    override fun openChat(url: String): LiveData<String> {
        return repository.remoteRepo.openChat(url)
    }
}


