package com.noosphereglobal.chatapp.presentation.view_models.base

import android.widget.Toast
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.noosphereglobal.chatapp.domain.IUseCases
import com.noosphereglobal.chatapp.presentation.ChatApp
import com.noosphereglobal.chatapp.presentation.view.base.IFragmentLifecycleCallbacks

abstract class ABaseViewModel(val interactor: IUseCases) : ViewModel(), IFragmentLifecycleCallbacks {
    override fun onStart() {}
    override fun onViewCreated() {}

    fun showToast(@StringRes mesId: Int) {
        Toast.makeText(ChatApp.getInstance(),
                ChatApp.getInstance().resources.getText(mesId),
                Toast.LENGTH_LONG).show()
    }
}