package com.jesuitasrioja.android_entrega11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupWithNavController
import com.jesuitasrioja.android_entrega11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @Suppress("unused")
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )

        //TOOLBAR
        //setSupportActionBar(binding.toolbar)

        //Cambiar texto navbar dependiendo del fragment
        //NavController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.title_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        //appBarConfiguration
        //val appBarConfiguration = AppBarConfiguration(navController.graph)

        //Toolbar a Navigation
        //binding.toolbar.setupWithNavController(navController, appBarConfiguration)

    }
}