package com.noosphereglobal.chatapp.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.models.Chat
import com.noosphereglobal.chatapp.util.d
import javax.inject.Inject

class MainFragmentViewModel @Inject constructor() : AMainFragmentViewModel() {

    override val list: LiveData<List<Chat>> = MutableLiveData(mutableListOf(Chat("", listOf())))
    override val startChatFr: LiveData<Int?> = MutableLiveData(null)

    override fun onViewCreated() {
        (startChatFr as MutableLiveData).value = null
    }

    override fun clickBtnConnect() {
        d("clickBtnConnect")
        (startChatFr as MutableLiveData).value = EFragments.CHAT_1.frId
    }

    override fun setName(name: String?) {
        d("setName; $name")
    }

    override fun setUrl(url: String?) {
        d("setUrl; $url")
    }

    override fun setClickItemPos(pos: Int) {
        d("setClickItemPos; $pos")
    }
}