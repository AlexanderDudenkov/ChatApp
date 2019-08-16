package com.noosphereglobal.chatapp.domain

import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.repo.local.models.ChatRealm
import com.noosphereglobal.chatapp.repo.local.models.MessageRealm
import com.noosphereglobal.chatapp.repo.remote.SocketServiceModel
import io.realm.RealmList

fun Message.messageToSocketServiceModel() = SocketServiceModel(name, text)

fun SocketServiceModel.socketServiceModelToMessage() = Message(name, text)

fun ChatRealm.toChat() = Chat(socketUrl ?: "").also { to ->
    to.messageList = ArrayList<Message>().apply {
        this@toChat.messageList?.forEach { add(it.toMessage()) }
    }
    to.date = date ?: ""
}

fun Chat.toChatRealm() = ChatRealm().also { to ->
    to.socketUrl = socketUrl
    to.date = date
    to.messageList = RealmList<MessageRealm>().apply {
        this@toChatRealm.messageList.forEach { add(it.toMessageRealm()) }
    }
}

fun MessageRealm.toMessage() = Message(name, text).also { it.time = time ?: "" }

fun Message.toMessageRealm() = MessageRealm().also {
    it.name = name
    it.text = text
    it.time = time
}