package com.noosphereglobal.chatapp.data

import com.noosphereglobal.chatapp.util.getDate

data class Chat(var socketUrl: String, var messageList: List<Message> = ArrayList()) {
    var date: String = getDate()
}

