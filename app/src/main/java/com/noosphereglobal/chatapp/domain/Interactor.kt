package com.noosphereglobal.chatapp.domain

import androidx.lifecycle.LiveData
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

        repository.remoteRepo.openChat(url) { error ->
            if (error.isNullOrEmpty()) {
                repository.localRepo.getChat(getDate()) {
                    if ((it == null) || (it.socketUrl != url)) {
                        repository.localRepo.setChat(Chat(url))
                        updateDb()
                    }
                }
            }
            setErrorListener(error)
        }
    }

    override fun getChat(chatDate: String): LiveData<Chat?> {
        return repository.localRepo.getChat(chatDate)
    }

    override fun getChat(date: String, chatListener: (chat: Chat?) -> Unit) {
        repository.localRepo.getChat(date, chatListener)
    }

    override fun sendMessage(mes: String, setErrorListener: (error: String?) -> Unit) {
        val message = Message(name, mes)
        repository.localRepo.setMessage(name, url, getDate(), message) {
            repository.remoteRepo.sendMessage(message, setErrorListener)
        }
    }

    override fun closeConnection() {
     /*todo closing db and net*/
    }

    protected open fun updateDb() {
        repository.remoteRepo.getMessage().observeForever { message ->
            if (message != null) {
                repository.localRepo.setMessage(name, url, getDate(), message)
            }
        }
    }
}


