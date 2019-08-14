package com.noosphereglobal.chatapp.domain

import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.repo.remote.SocketServiceModel

fun Message.messageToSocketServiceModel() = SocketServiceModel(name, text)

fun SocketServiceModel.socketServiceModelToMessage() = Message(name, text)