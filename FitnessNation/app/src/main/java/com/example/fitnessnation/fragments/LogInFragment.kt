package com.example.fitnessnation

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitnessnation.activitites.BottomNavigationActivity
import com.example.fitnessnation.activitites.LoginActivity
import kotlinx.android.synthetic.main.fragment_log_in.*

class LogInFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var vieww: View? = null

    companion object{
        fun newInstance()= LogInFragment()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_log_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        users = LoginActivity.appDatabase.dao().getUsers()

      username = view!!.findViewById(R.id.Username)
      password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

      login_button.setOnClickListener(View.OnClickListener {
          val username = Username.getText().toString()
          val password = Password.getText().toString()
          LoginButtonExecute(username, password)

          users = LoginActivity.appDatabase.dao().getUsers()
      })

    }


    fun LoginButtonExecute(username: String, password: String) {
        if (username == "" || password == "") {
            Toast.makeText(activity, "You didn't fill one of boxes", Toast.LENGTH_SHORT).show()
        } else {
            val user = User()
            user.setUsername(username)
            user.setPassword(password)
            if (findUser(user)) {
                Toast.makeText(activity, "You are logged in", Toast.LENGTH_SHORT).show()
                goToNextActivity(user)
                
            } else {
                Toast.makeText(activity, "No such user", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goToNextActivity(user:User)
    {
        val intent = Intent(activity, BottomNavigationActivity::class.java)
        intent.putExtra("user",user);
        startActivity(intent)
    }


    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword())) return true
        }
        return false
    }


}