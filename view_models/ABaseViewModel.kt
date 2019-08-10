package com.noosphereglobal.chatapp.view_models

import androidx.lifecycle.ViewModel
import com.noosphereglobal.chatapp.view.base.IFragmentLifecycleCallbacks

abstract class ABaseViewModel : ViewModel(), IFragmentLifecycleCallbacks{
    override fun onStart() {}
    override fun onViewCreated() {}
}