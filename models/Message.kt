package com.noosphereglobal.chatapp.models

import com.noosphereglobal.chatapp.util.getTime

data class Message(var name:String, var text:String){
    val time:String = getTime()
}
