package com.noosphereglobal.chatapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.view.base.ABaseFragment

class ChatFragment : ABaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }
}
