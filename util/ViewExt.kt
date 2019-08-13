package com.noosphereglobal.chatapp.util

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation

fun FragmentActivity?.startFragment(@IdRes navFrId: Int, @IdRes frId: Int) {
    if (this == null) return

    val navController = Navigation.findNavController(this, navFrId)
    if (navController.currentDestination?.id != frId) {
        navController.navigate(frId)
    }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(this.context).inflate(layoutRes, this, attachToRoot)

fun Activity?.hideKeyBoard(): Boolean {
    val view = this?.currentFocus
    if (view != null) {
        (this?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                .hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        return true
    }
    return false
}