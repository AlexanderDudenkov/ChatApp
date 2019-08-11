package com.noosphereglobal.chatapp.presentation.view_models.base

import androidx.annotation.IdRes
import com.noosphereglobal.chatapp.R

enum class EFragments(@IdRes val frId: Int) {
    MAIN(R.id.mainFragment),
    CHAT(R.id.chatFragment),
    VIEW_CHAT(R.id.viewChatFragment)
}