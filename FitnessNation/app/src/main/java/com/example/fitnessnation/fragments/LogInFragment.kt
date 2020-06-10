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
import kotlinx.android.synthetic.main.fragment_log_in.*
import java.util.*

class LogInFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var view: View? = null
    private var recyclerView: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: Recycler? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.fragment_log_in, container, false)
        RefreshRecycle()
        username = view!!.findViewById(R.id.Username)
        password = view!!.findViewById(R.id.Password)
        loginButton = view!!.findViewById(R.id.login_button)
        login_button.setOnClickListener(View.OnClickListener {
            val username = Username.getText().toString()
            val password = Password.getText().toString()
            AddButtonExecute(username, password)
            RefreshRecycle()
        })

        return view
    }

    fun LoginButtonExecute(username: String, password: String) {
        if (username == "" || password == "") {
            Toast.makeText(
                activity,
                "You didn't fill one of the EditText boxes",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val user = User()
            user.setUsername(username)
            user.setPassword(password)
            if (findUser(user)) {
                Toast.makeText(activity, "This user already exist", Toast.LENGTH_SHORT).show()
            } else {
                LoginActivity.appDatabase.get().dao().addUser(user)
                Toast.makeText(activity, "User added successfully", Toast.LENGTH_SHORT).show()
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
            user.setFirst_name(firstName)
            user.setLast_name(lastName)
            if (!findUser(user)) {
                Toast.makeText(
                    activity,
                    "First name or last name are incorrect",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                MainActivity.appDatabase.dao().deleteUser(user)
                Toast.makeText(activity, "User deleted successfully", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.getFirst_name().equals(user.getFirst_name()) && usr.getLast_name().equals(user.getLast_name())) return true
        }
        return false
    }

    fun RefreshRecycle() {
        recyclerView = view!!.findViewById(R.id.recycle_view)
        layoutManager = LinearLayoutManager(context)
        recyclerView.setLayoutManager(layoutManager)
        users = MainActivity.appDatabase.dao().getUsers()
        val itemList: MutableList<String> =
            ArrayList()
        var infoAboutUser = ""
        for (usr in users!!) {
            val firstName: String = usr.getFirst_name()
            val lastName: String = usr.getLast_name()
            infoAboutUser = "$firstName $lastName"
            itemList.add(infoAboutUser)
        }
        adapter = Recycler(itemList)
        recyclerView.setHasFixedSize(true)
        recyclerView.setAdapter(adapter)
    }

    companion object {
        fun newInstance(): fragment {
            return fragment()
        }
    }
}