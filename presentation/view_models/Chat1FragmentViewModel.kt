package com.noosphereglobal.chatapp.presentation.view_models

import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AChat1FragmentViewModel
import javax.inject.Inject

open class Chat1FragmentViewModel @Inject constructor(interactor: IUseCases) : AChat1FragmentViewModel(interactor) {

    override fun onViewCreated() {

    }
}