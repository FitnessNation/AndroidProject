package com.example.fitnessnation.activitites

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.fitnessnation.AppDatabase
import com.example.fitnessnation.LogInFragment
import com.example.fitnessnation.R
import com.example.fitnessnation.fragments.MenuLoginFragment

class LoginActivity : AppCompatActivity() {

   private var appDatabase: AppDatabase?=null
       get() = field


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setFirstFragment()
       appDatabase = Room.databaseBuilder<AppDatabase>(
            applicationContext,
            AppDatabase::class.java, "userdatabase"
        ).allowMainThreadQueries().build()
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment.newInstance()).commitNow()
        }

    }

    fun setFirstFragment() {
        val fragment: MenuLoginFragment = MenuLoginFragment.newInstance()

        val transaction =supportFragmentManager.beginTransaction()
      transaction.add(R.id.primary_frame_s_session, fragment)
        transaction.addToBackStack(MenuLoginFragment.toString())
        transaction.commit()
    }


}
