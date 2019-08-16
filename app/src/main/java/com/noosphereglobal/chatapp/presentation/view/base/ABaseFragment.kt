package com.noosphereglobal.chatapp.presentation.view.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.util.startFragment

abstract class ABaseFragment : Fragment() {

    fun startMainActivityFragment(@IdRes frId: Int) {
        activity.startFragment(R.id.nav_host_fragment, frId)
    }
}
