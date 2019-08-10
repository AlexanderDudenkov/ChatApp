package com.noosphereglobal.chatapp.models

import com.noosphereglobal.chatapp.util.getDate

data class Chat(var socketUrl: String, var chatList: List<Message> = ArrayList()){
    val date: String = getDate()
}

