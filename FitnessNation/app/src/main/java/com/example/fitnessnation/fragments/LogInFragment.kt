package com.example.fitnessnation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.activitites.LoginActivity
import com.example.fitnessnation.fragments.MenuLoginFragment
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_logo.*
import kotlinx.android.synthetic.main.fragment_menu_login.*
import java.util.*

class LogInFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var vieww: View? = null
    lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: Recycler? = null

    companion object{
        fun newInstance()= LogInFragment()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,  savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_log_in, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RefreshRecycle()

      username = view!!.findViewById(R.id.Username)
      password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

      login_button.setOnClickListener(View.OnClickListener {
          val username = Username.getText().toString()
          val password = Password.getText().toString()
          LoginButtonExecute(username, password)
          RefreshRecycle()
      })

    }



    fun LoginButtonExecute(username: String, password: String) {
        if (username == "" || password == "") {
            Toast.makeText(
                activity,
                "You didn't fill one of boxes",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val user = User()
            user.setUsername(username)
            user.setPassword(password)
            if (findUser(user)) {
                Toast.makeText(activity, "You are logged in", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "No such user", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun DeleteButtonExecute(firstName: String, lastName: String) {
        if (firstName == "" || lastName == "") {
            Toast.makeText(
                activity,
                "You didn't fill one of the EditText boxes",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val user = User()
            user.setUsername(firstName)
            user.setPassword(lastName)
            if (!findUser(user)) {
                Toast.makeText(activity, "First name or last name are incorrect", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "User deleted successfully", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword())) return true
        }
        return false
    }

    private fun RefreshRecycle() {
        recyclerView = view!!.findViewById(R.id.recycle_view)
        layoutManager = LinearLayoutManager(context)
        recyclerView.setLayoutManager(layoutManager)
        users = LoginActivity.appDatabase.dao().getUsers()
        val itemList: MutableList<String> =
            ArrayList()
        var infoAboutUser = ""
        for (usr in users!!) {
            val firstName: String = usr.getUsername()
            val lastName: String = usr.getPassword()
            infoAboutUser = "$firstName $lastName"
            itemList.add(infoAboutUser)
        }
        adapter = Recycler(itemList)
        recyclerView.setHasFixedSize(true)
        recyclerView.setAdapter(adapter)
    }

}