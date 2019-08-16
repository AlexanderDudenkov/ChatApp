package com.noosphereglobal.chatapp.repo.local.models

import io.realm.RealmList
import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.security.SecureRandom
import java.util.*

@RealmClass
open class ChatRealm : RealmModel {
    @PrimaryKey
    var id: Long = SecureRandom().nextLong()
    var socketUrl: String? = null
    var date: String? = null
    var messageList: RealmList<MessageRealm>? = null
}

