package com.noosphereglobal.chatapp.presentation.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.view_models.base.AViewChatFragmentViewModel
import javax.inject.Inject

open class ViewChatFragmentViewModel @Inject constructor(interactor: IUseCases) : AViewChatFragmentViewModel(interactor) {

    override val list: LiveData<List<Message>> = MutableLiveData(mutableListOf(
            Message("name1", "text1"),
            Message("name2", "text2"),
            Message("name3", "text3"))
    )
}