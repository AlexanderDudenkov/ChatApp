package com.noosphereglobal.chatapp.presentation.view_models.base

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.domain.IUseCases

abstract class AMainFragmentViewModel(interactor: IUseCases) : ABaseViewModel(interactor) {
    abstract val list: LiveData<List<Chat>>
    abstract val startChatFr: LiveData<Int?>
    abstract val selectedChat: LiveData<Chat>

    abstract fun clickBtnConnect()
    abstract fun setName(name: String?)
    abstract fun setUrl(url: String?)
    abstract fun setClickItemPos(pos: Int)
    override fun onDestroy() {}
}
