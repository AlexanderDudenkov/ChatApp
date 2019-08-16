package com.noosphereglobal.chatapp.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController

import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.di.injector
import com.noosphereglobal.chatapp.presentation.view_models.ChatFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AMainFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.MainFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.ViewChatFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AChatFragmentViewModel
import com.noosphereglobal.chatapp.presentation.view_models.base.AViewChatFragmentViewModel
import com.noosphereglobal.chatapp.util.hideKeyBoard

class MainActivity : AppCompatActivity() {

    val mainVM: AMainFragmentViewModel by lazy {
        ViewModelProviders.of(this, injector.mainViewModelFactory()).get(MainFragmentViewModel::class.java)
    }

    val viewChatVM: AViewChatFragmentViewModel by lazy {
        ViewModelProviders.of(this, injector.viewChatViewModelFactory()).get(ViewChatFragmentViewModel::class.java)
    }

    val chatVM: AChatFragmentViewModel by lazy {
        ViewModelProviders.of(this, injector.chatViewModelFactory()).get(ChatFragmentViewModel::class.java)
    }

    val navController: NavController by lazy { findNavController(this, R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onDestroy() {
        mainVM.onDestroy()
        super.onDestroy()
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    override fun onBackPressed() {
        hideKeyBoard()
        super.onBackPressed()
    }
}
