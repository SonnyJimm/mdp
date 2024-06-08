package com.mdp.animalkingdom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI


class MainActivity : AppCompatActivity() {
    private lateinit var mnNavController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
         mnNavController = navHostFragment.navController;
//        appBarConfiguration = AppBarConfiguration(mnNavController.graph)

        // Ensure the ActionBar is initialized
        NavigationUI.setupActionBarWithNavController(this,mnNavController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return mnNavController.navigateUp()
    }
}