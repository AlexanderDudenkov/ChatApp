package com.noosphereglobal.chatapp.repo.remote

import com.noosphereglobal.chatapp.data.IMessage

data class Responce(override var name: String, override var text: String) : IMessage