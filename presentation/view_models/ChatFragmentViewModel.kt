package com.noosphereglobal.chatapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AChatFragmentViewModel
import javax.inject.Inject

open class ChatFragmentViewModel @Inject constructor(interactor: IUseCases) : AChatFragmentViewModel(interactor) {

    override val list: LiveData<List<Message>> = MutableLiveData(listOf(Message("name1", "text1"),
            Message("name1", "text1"),
            Message("name1", "text1")))

    override fun setMessage(text: String?) {

    }

    override fun ckickBtnSend() {

    }
}