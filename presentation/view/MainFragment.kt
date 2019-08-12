package com.noosphereglobal.chatapp.presentation.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.di.components.DaggerIMainFragmentComponent
import com.noosphereglobal.chatapp.di.injector
import com.noosphereglobal.chatapp.di.modules.MainFragmentModule
import com.noosphereglobal.chatapp.data.Chat
import com.noosphereglobal.chatapp.presentation.view.base.ABaseFragment
import com.noosphereglobal.chatapp.presentation.view.base.BaseRecyclerAdapter
import com.noosphereglobal.chatapp.presentation.view.base.BaseViewHolder
import com.noosphereglobal.chatapp.presentation.view_models.base.ABaseViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AMainFragmentViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

open class MainFragment : ABaseFragment() {

    @Inject
    lateinit var lm: RecyclerView.LayoutManager

    @Inject
    lateinit var adapter: BaseRecyclerAdapter<BaseViewHolder<Any>>

    protected open var component: Any? = null
    protected open val vm: ABaseViewModel by lazy { (activity as MainActivity).mainVM }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        vm.onViewCreated()
        initDI()
        init()
    }

    override fun onDestroy() {
        component = null
        super.onDestroy()
    }

    protected open fun initDI() {
        component = DaggerIMainFragmentComponent.builder()
                .iAppComponent((activity as MainActivity).injector)
                .mainFragmentModule(MainFragmentModule(activity as MainActivity))
                .build()
                .apply { inject(this@MainFragment) }
    }

    protected open fun init() {
        et_name_fragment_main?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (vm as AMainFragmentViewModel).setName(s.toString())
            }
        })

        et_url_fragment_main?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                (vm as AMainFragmentViewModel).setUrl(s.toString())
            }
        })

        btn_connect_fragment_main?.setOnClickListener { (vm as AMainFragmentViewModel).clickBtnConnect() }

        rv_chat_fragment_main?.also {
            it.adapter = this.adapter.apply {
                onClickListener = { pos -> (vm as AMainFragmentViewModel).setClickItemPos(pos) }
            }
            it.layoutManager = lm
        }

        (vm as AMainFragmentViewModel).run {
            list.observe(this@MainFragment, Observer { update(it) })
            startChatFr.observe(this@MainFragment, Observer {
                if (it != null) startMainActivityFragment(it)
            })
        }
    }

    protected open fun update(list: List<Chat>) {
        adapter.setList(list)
    }

}
