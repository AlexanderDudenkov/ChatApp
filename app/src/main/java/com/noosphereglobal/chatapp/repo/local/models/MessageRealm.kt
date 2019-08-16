package com.noosphereglobal.chatapp.repo.local.models

import com.noosphereglobal.chatapp.data.IMessage
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.security.SecureRandom

@RealmClass
open class MessageRealm : IMessage, RealmModel {
    override var name: String = ""
    override var text: String = ""
    @PrimaryKey
    var id: Long = SecureRandom().nextLong()
    var time: String? = null
}
