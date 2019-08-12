package com.noosphereglobal.chatapp.presentation.view_models

import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AChatFragmentViewModel
import javax.inject.Inject

open class ChatFragmentViewModel @Inject constructor(interactor: IUseCases) : AChatFragmentViewModel(interactor) {

    override fun onViewCreated() {

    }
}