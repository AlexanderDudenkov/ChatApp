package com.noosphereglobal.chatapp.util

import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation

fun FragmentActivity?.startFragment(@IdRes navFrId: Int, @IdRes frId: Int) {
    if (this == null) return

    val navController = Navigation.findNavController(this, navFrId)
    if (navController.currentDestination?.id != frId) {
        navController.navigate(frId)
    }
}