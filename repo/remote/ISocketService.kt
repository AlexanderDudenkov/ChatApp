package com.noosphereglobal.chatapp.repo.remote

import androidx.lifecycle.LiveData

interface ISocketService{
    fun getMessage(): LiveData<String?>
    fun openChat(url: String): LiveData<String?>
    fun sendMessage(json: String): LiveData<String?>
}