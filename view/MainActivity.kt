package com.noosphereglobal.chatapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController

import com.noosphereglobal.chatapp.R
import com.noosphereglobal.chatapp.di.injector
import com.noosphereglobal.chatapp.view.base.INavigation
import com.noosphereglobal.chatapp.view_models.AMainFragmentViewModel
import com.noosphereglobal.chatapp.view_models.MainFragmentViewModel

class MainActivity : AppCompatActivity()/*, INavigation*/ {

    val mainViewVM: AMainFragmentViewModel by lazy {
        ViewModelProviders.of(this, injector.mainViewModelFactory()).get(MainFragmentViewModel::class.java)
    }

    val navController: NavController by lazy { findNavController(this, R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
