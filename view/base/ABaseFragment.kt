package com.noosphereglobal.chatapp.view.base

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.util.startFragment
import com.noosphereglobal.chatapp.view.MainActivity

abstract class ABaseFragment : Fragment() {

    fun startMainActivityFragment(@IdRes frId: Int) {
        activity.startFragment(R.id.nav_host_fragment, frId)
    }
}
