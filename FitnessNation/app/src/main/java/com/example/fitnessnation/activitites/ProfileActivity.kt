package com.example.fitnessnation.activitites

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessnation.R
import com.example.fitnessnation.User


class ProfileActivity : AppCompatActivity() {
    private var user: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
      // user = intent.getSerializableExtra("Editing") as User
       user= getIntent().getSerializableExtra("user") as User?;
       Toast.makeText(this, user!!.getUsername(), Toast.LENGTH_SHORT).show()
    }
}
