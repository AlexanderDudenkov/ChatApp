package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.kotlin.addChangeListener
import io.realm.kotlin.removeChangeListener

class RealmModelLiveData(private val realmModel: RealmModel?) : LiveData<RealmModel>() {

    init {
        realmModel?.let {
            postValue(realmModel)
        }
    }

    private val listener = RealmChangeListener<RealmModel> { postValue(it) }

    override fun onActive() {
        realmModel?.addChangeListener(listener)
    }

    override fun onInactive() {
        realmModel?.removeChangeListener(listener)
    }
}