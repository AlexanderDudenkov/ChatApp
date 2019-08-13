package com.noosphereglobal.chatapp.presentation.view_models.base

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.IUseCases

abstract class AChatFragmentViewModel(interactor: IUseCases) : ABaseViewModel(interactor) {
    abstract val list: LiveData<List<Message>>

    abstract fun setMessage(text: String?)
    abstract fun ckickBtnSend()
}
