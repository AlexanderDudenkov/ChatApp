package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData

interface ISocketService {
    fun getMessage(): LiveData<String?>
    fun openChat(url: String, setErrorListener: (error: String?) -> Unit)
    fun sendMessage(json: String, setErrorListener: (error: String?) -> Unit)
}