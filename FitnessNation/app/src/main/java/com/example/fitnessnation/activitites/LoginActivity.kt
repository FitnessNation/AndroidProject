package com.example.fitnessnation.activitites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessnation.R
import com.example.fitnessnation.fragments.MenuLoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setFirstFragment()
    }

    fun setFirstFragment() {
        val fragment: MenuLoginFragment = MenuLoginFragment.newInstance()

        val transaction =supportFragmentManager.beginTransaction()
      transaction.add(R.id.primary_frame_s_session, fragment)
        transaction.addToBackStack(MenuLoginFragment.toString())
        transaction.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
