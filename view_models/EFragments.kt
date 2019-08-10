package com.noosphereglobal.chatapp.view_models

import androidx.annotation.IdRes
import com.noosphereglobal.chatapp.R

enum class EFragments(@IdRes val frId:Int) {
    MAIN(R.id.mainFragment),
    CHAT_1(R.id.chatFragment)
}