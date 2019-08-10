package com.noosphereglobal.chatapp.view_models.base

import androidx.lifecycle.LiveData
import com.noosphereglobal.chatapp.models.Chat

abstract class AMainFragmentViewModel : ABaseViewModel() {
    abstract val list: LiveData<List<Chat>>
    abstract val startChatFr: LiveData<Int?>

    abstract fun clickBtnConnect()
    abstract fun setName(name: String?)
    abstract fun setUrl(url: String?)
    abstract fun setClickItemPos(pos: Int)
}
