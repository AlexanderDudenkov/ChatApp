package com.noosphereglobal.chatapp.presentation.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.presentation.view_models.base.ABaseViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AChatFragmentViewModel
import com.noosphereglobal.chatapp.util.hideKeyBoard
import kotlinx.android.synthetic.main.fragment_chat.*

open class ChatFragment : ViewChatFragment() {

    override val vm: ABaseViewModel by lazy { (activity as MainActivity).chatVM }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.onViewCreated()
        initDI()
        initRv()
        init()
        initEditText()
        initBntSend()
    }

    override fun init() {
        (vm as AChatFragmentViewModel).list.observe(this, Observer { update(it) })
    }

    protected open fun initEditText() {
        et_message_fragment_chat?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (vm as AChatFragmentViewModel).setMessage(s.toString())
            }
        })
    }

    protected open fun initBntSend() {
        btn_send_fragment_chat?.setOnClickListener {
            (vm as AChatFragmentViewModel).ckickBtnSend()
            et_message_fragment_chat?.setText("")
            activity.hideKeyBoard()
        }
    }
}
