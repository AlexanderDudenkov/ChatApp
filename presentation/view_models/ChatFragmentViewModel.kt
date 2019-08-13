package com.noosphereglobal.chatapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AChatFragmentViewModel
import com.noosphereglobal.chatapp.util.getDate
import javax.inject.Inject

open class ChatFragmentViewModel @Inject constructor(interactor: IUseCases) : AChatFragmentViewModel(interactor) {

    override val list: LiveData<List<Message>> = MediatorLiveData()

    protected open var text: String? = null

    override fun onViewCreated() {
        (list as MediatorLiveData).addSource(interactor.getChat(getDate())) {
            (list as MediatorLiveData).postValue(it.chatList)
        }
    }

    override fun setMessage(text: String?) {
         this.text = text
    }

    override fun ckickBtnSend() {
        text?.let {
            interactor.sendMessage(text!!).observeForever { errorMes ->
                if (!errorMes.isNullOrEmpty()) showToast(errorMes)
            }
        }
    }
}