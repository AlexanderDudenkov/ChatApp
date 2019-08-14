package com.noosphereglobal.chatapp.repo.remote

import com.noosphereglobal.chatapp.data.IMessage

class SocketServiceModel(override var name: String, override var text: String) : IMessage