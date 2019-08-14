package com.noosphereglobal.chatapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AMainFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.EFragments
import javax.inject.Inject

open class MainFragmentViewModel @Inject constructor(interactor: IUseCases) : AMainFragmentViewModel(interactor) {

    final override val list: LiveData<List<Chat>> = MediatorLiveData()
    override val startChatFr: LiveData<Int?> = MutableLiveData(null)
    override val selectedChat: LiveData<Chat> = MutableLiveData()

    protected open var userName: String? = null
    protected open var socketUrl: String? = null

    init {
        (list as MediatorLiveData).addSource(interactor.getChatList()) { list.postValue(it) }
    }

    override fun onViewCreated() {
        (startChatFr as MutableLiveData).value = null
    }

    override fun clickBtnConnect() {
        openChat(userName, socketUrl)
    }

    override fun setName(name: String?) {
        userName = name
    }

    override fun setUrl(url: String?) {
        socketUrl = url
    }

    override fun setClickItemPos(pos: Int) {
        (selectedChat as MutableLiveData).value = list.value?.get(pos)
        (startChatFr as MutableLiveData).value = EFragments.VIEW_CHAT.frId
    }

    protected open fun openChat(name: String?, url: String?) {
        if (!name.isNullOrEmpty() && !url.isNullOrEmpty()) {

            interactor.openChat(name, url) { errorMes ->
                if (!errorMes.isNullOrEmpty()) {
                    showToast(R.string.failed_to_open_chat)
                } else
                    (startChatFr as MutableLiveData).value = EFragments.CHAT.frId
            }
        } else {
            showToast(R.string.input_name_and_url)
        }
    }
}