package com.example.fitnessnation.activitites

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.fitnessnation.R
import com.example.fitnessnation.User
import com.example.fitnessnation.fragments.StatisticsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class BottomNavigationActivity : AppCompatActivity() {
    var user: User? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        user= getIntent().getSerializableExtra("user") as User?;
        Toast.makeText(this, user!!.getUsername(), Toast.LENGTH_SHORT).show()



        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_statistics, R.id.navigation_profile, R.id.navigation_meal, R.id.navigation_notifications)
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        passUserToFragments(navController)
    }

    fun passUserToFragments(navController: NavController)
    {
        val bundle = bundleOf("user" to user)
        navController.navigate(R.id.navigation_statistics, bundle)
        navController.navigate(R.id.navigation_meal, bundle)
        navController.navigate(R.id.navigation_notifications, bundle)
        navController.navigate(R.id.navigation_profile, bundle)
    }



}
