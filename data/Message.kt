package com.noosphereglobal.chatapp.data

import com.noosphereglobal.chatapp.util.getTime

data class Message(override var name: String, override var text: String) : IMessage {
    val time: String = getTime()
}
