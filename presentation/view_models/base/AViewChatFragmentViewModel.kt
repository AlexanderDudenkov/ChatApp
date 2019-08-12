package com.noosphereglobal.chatapp.presentation.view_models.base

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.IUseCases

abstract class AViewChatFragmentViewModel(interactor: IUseCases) : ABaseViewModel(interactor) {
    abstract val list: LiveData<List<Message>>

    abstract fun setChatFromMainFragment(chat: Chat)
}
