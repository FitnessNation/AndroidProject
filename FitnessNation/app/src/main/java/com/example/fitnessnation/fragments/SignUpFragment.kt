package com.example.fitnessnation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.LogInFragment

import com.example.fitnessnation.R
import com.example.fitnessnation.Recycler
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.LoginActivity
import kotlinx.android.synthetic.main.fragment_log_in.*
import kotlinx.android.synthetic.main.fragment_log_in.Password
import kotlinx.android.synthetic.main.fragment_log_in.Username
import kotlinx.android.synthetic.main.fragment_sign_up.*
import java.util.ArrayList


class SignUpFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var vieww: View? = null
    lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: Recycler? = null

    companion object {
        fun newInstance() = SignUpFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(getActivity()?.getApplicationContext(), "SignUp", Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RefreshRecycle()

        username = view!!.findViewById(R.id.Username)
        password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

        signup_button.setOnClickListener(View.OnClickListener {
            val username = Username.getText().toString()
            val password = Password.getText().toString()
           SignUpButtonExecute(username, password)
           RefreshRecycle()

        })
    }

    fun SignUpButtonExecute(username: String, password: String) {
        if (username == "" || password == "") {
            Toast.makeText(
                activity,
                "You didn't fill all the boxes",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val user = User()
            user.setUsername(username)
            user.setPassword(password)
            if (findUser(user)) {
                Toast.makeText(activity, "User is already registered", Toast.LENGTH_SHORT).show()
            } else {
                LoginActivity.appDatabase.dao().addUser(user)
                Toast.makeText(activity, "Succesfully registered!", Toast.LENGTH_SHORT).show()
                toTheLoginFragment();
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


    private fun toTheLoginFragment()
    {
        val transaction = fragmentManager!!.beginTransaction()
        transaction.replace(R.id.primary_frame_s_session, LogInFragment.newInstance())
        transaction.addToBackStack(LogInFragment.toString())
        transaction.commit()
    }

    fun findUser(user: User): Boolean {
        for (usr in users!!) {
            if (usr.getUsername().equals(user.getUsername()) && usr.getPassword().equals(user.getPassword())) return true
        }
        return false
    }

    private fun RefreshRecycle() {
        recyclerView = view!!.findViewById(R.id.recycle_view)
        layoutManager = LinearLayoutManager(context) as RecyclerView.LayoutManager?
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
