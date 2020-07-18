package com.example.architecturecomponent.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.architecturecomponent.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)
        val navController:NavController=Navigation.findNavController(this,R.id.nav_host_fragment);
        setupBottomNav(navController)
        setupSideNav(navController)
        setupActionBar(navController)
    }

    private fun setupActionBar(navController: NavController) {
        NavigationUI.setupActionBarWithNavController(this,navController,drawer_layout);
    }

    private fun setupSideNav(navController: NavController) {
        nav_view?.let {
            NavigationUI.setupWithNavController(it,navController);
        }
    }

    private fun setupBottomNav(navController: NavController) {
        bottom_nav?.let {
            NavigationUI.setupWithNavController(it,navController)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        val  navigated=NavigationUI.onNavDestinationSelected(item!!,navController)
        return navigated || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this,R.id.nav_host_fragment),drawer_layout)
    }
}