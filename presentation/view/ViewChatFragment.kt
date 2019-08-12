package com.noosphereglobal.chatapp.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.data.Message
import com.noosphereglobal.chatapp.di.components.DaggerIViewChatFragmentComponent
import com.noosphereglobal.chatapp.di.injector
import com.noosphereglobal.chatapp.di.modules.ViewChatFragmentModule
import com.noosphereglobal.chatapp.presentation.view.base.ABaseFragment
import com.noosphereglobal.chatapp.presentation.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseViewHolder
import com.noosphereglobal.chatapp.presentation.view_models.base.ABaseViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AMainFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AViewChatFragmentViewModel
import kotlinx.android.synthetic.main.fragment_chat_view.*
import javax.inject.Inject

open class ViewChatFragment : ABaseFragment() {

    @Inject
    lateinit var lm: RecyclerView.LayoutManager

    @Inject
    lateinit var adapter: BaseRecyclerAdapter<BaseViewHolder<Any>>

    protected open var component: Any? = null
    protected open val viewChatVM: ABaseViewModel by lazy { (activity as MainActivity).viewChatVM }
    protected open val mainVM: ABaseViewModel by lazy { (activity as MainActivity).mainVM }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_chat_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewChatVM.onViewCreated()
        initDI()
        init()
    }

    override fun onDestroy() {
        component = null
        super.onDestroy()
    }

    protected open fun initDI() {
        component = DaggerIViewChatFragmentComponent.builder()
                .iAppComponent((activity as MainActivity).injector)
                .viewChatFragmentModule(ViewChatFragmentModule(activity as MainActivity))
                .build()
                .apply { inject(this@ViewChatFragment) }
    }

    protected open fun init() {
        rv_fragment_chat_view?.also {
            it.adapter = this.adapter
            it.layoutManager = lm
        }

        (viewChatVM as AViewChatFragmentViewModel).list.observe(this, Observer { update(it) })
        (mainVM as AMainFragmentViewModel).selectedChat.observe(this, Observer {
            (viewChatVM as AViewChatFragmentViewModel).setChatFromMainFragment(it)
        })
    }

    protected open fun update(list: List<Message>) {
        adapter.setList(list)
    }
}
