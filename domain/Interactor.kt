package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.repo.IRepository
import com.noosphereglobal.chatapp.util.getDate
import javax.inject.Inject

open class Interactor @Inject constructor(private val repository: IRepository) : IUseCases {

    protected open var name = ""
    protected open var url = ""

    override fun getChatList(): LiveData<List<Chat>> {
        return repository.localRepo.getChatList()
    }

    override fun openChat(userName: String, url: String, setErrorListener: (error: String?) -> Unit) {
        name = userName
        this.url = url
        repository.remoteRepo.openChat(url, setErrorListener)
    }

    override fun getChat(chatDate: String): LiveData<Chat?> {
        return Transformations.switchMap(repository.remoteRepo.getMessage() as MutableLiveData) { message ->
            if (message != null) {
                repository.localRepo.setMessage(name, url, chatDate, message) {
                    repository.localRepo.getChat(chatDate)
                }
                repository.localRepo.getChat(chatDate)
            } else MutableLiveData<Chat?>(null)
        }
    }

    override fun sendMessage(mes: String, setErrorListener: (error: String?) -> Unit) {
        val message = Message(name, mes)
        repository.localRepo.setMessage(name, url, getDate(), message) {
            repository.remoteRepo.sendMessage(message, setErrorListener)
        }
    }
}


