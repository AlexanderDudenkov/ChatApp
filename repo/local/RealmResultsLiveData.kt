package com.noosphereglobal.chatapp.repo.local

import androidx.lifecycle.LiveData
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmResults

class RealmResultsLiveData<M : RealmModel>(private val realmResults: RealmResults<M>?) : LiveData<RealmResults<M>>() {

    init {
        realmResults?.let {
            postValue(realmResults)
        }
    }

    private val listener = RealmChangeListener<RealmResults<M>> {
        postValue(it)
    }

    override fun onActive() {
        realmResults?.addChangeListener(listener)
    }

    override fun onInactive() {
        realmResults?.removeChangeListener(listener)
    }
}