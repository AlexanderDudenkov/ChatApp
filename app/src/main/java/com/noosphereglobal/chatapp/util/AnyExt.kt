package com.noosphereglobal.chatapp.util

import android.util.Log
import android.widget.Toast
import androidx.annotation.StringRes
import com.noosphereglobal.chatapp.presentation.ChatApp
import java.text.SimpleDateFormat
import java.util.*

fun Any?.getDate() = if (this != null)
    SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date()) else ""

fun Any?.getDateTime() = if (this != null)
    SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(Date()) else ""

fun Any?.getTime() = if (this != null)
    SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date()) else ""

fun Any.d(tag: String) {
    Log.d(javaClass.simpleName, tag)
}