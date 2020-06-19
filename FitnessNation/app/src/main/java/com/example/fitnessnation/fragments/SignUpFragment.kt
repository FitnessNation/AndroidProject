package com.example.fitnessnation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.LogInFragment
import com.example.fitnessnation.R
import com.example.fitnessnation.RecyclerViewAdapter
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.LoginActivity
import kotlinx.android.synthetic.main.fragment_log_in.Password
import kotlinx.android.synthetic.main.fragment_log_in.Username
import kotlinx.android.synthetic.main.fragment_sign_up.*


class SignUpFragment : Fragment() {
    private var username: EditText? = null
    private var password: EditText? = null
    private var users: List<User>? = null
    private var loginButton: Button? = null
    private var vieww: View? = null
    lateinit var recyclerView: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerViewAdapter? = null

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

        users= LoginActivity.fitnessRepository.getUsersTask();

        username = view!!.findViewById(R.id.Username)
        password = view!!.findViewById(R.id.Password)

        loginButton = view!!.findViewById(R.id.login_button)

        signup_button.setOnClickListener(View.OnClickListener {
            val username = Username.getText().toString()
            val password = Password.getText().toString()
            val weight = weight.getText().toString()
            var goalWeight=goalweight.getText().toString()
           // weight.toIntOrNull();

            val height = height.getText().toString()
            //height.toIntOrNull();


            var gender:String="female"
            var weight_choice=false;




                if(female.isChecked)
                {
                    gender="female"
                    Toast.makeText(activity, "Female", Toast.LENGTH_SHORT).show()
                    if(weightloss.isChecked)
                    {
                        Toast.makeText(activity, "LOOSE", Toast.LENGTH_SHORT).show()
                        weight_choice=false;
                        SignUpButtonExecute(username, password,weight,height,gender,weight_choice,goalWeight)
                    }
                    else if(weightgain.isChecked)
                    {
                        Toast.makeText(activity, "GAIN", Toast.LENGTH_SHORT).show()
                        weight_choice=true;
                        SignUpButtonExecute(username, password,weight,height,gender,weight_choice,goalWeight)
                    } else
                    {
                        Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()
                    }
                }
                else if(male.isChecked())
                {
                    if(weightloss.isChecked())
                    {
                        weight_choice=false;
                        SignUpButtonExecute(username, password,weight,height,gender,weight_choice,goalWeight)
                    }
                    else if(weightgain.isChecked())
                    {
                        weight_choice=true;
                        SignUpButtonExecute(username, password,weight,height,gender,weight_choice,goalWeight)
                    } else
                    {
                        Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()
                    }
                } else
                {
                    Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()
                }


            users= LoginActivity.fitnessRepository.getUsersTask();

        })
    }

    fun SignUpButtonExecute(username: String, password: String,weight:String,height:String, gender: String,weight_choice:Boolean,goalweight:String) {

        val gw=goalweight.toIntOrNull()
        val w=weight.toIntOrNull()
        val h=height.toIntOrNull()
     if(weight.toIntOrNull()==null|| height.toIntOrNull()==null||goalweight.toIntOrNull()==null)
     {
    Toast.makeText(activity, "Weight, goalweight and height should be numbers", Toast.LENGTH_SHORT).show()
     }
        else
     {
         if (username == "" || password == "") {
             Toast.makeText(activity, "You didn't fill all the boxes", Toast.LENGTH_SHORT).show()
         } else {
             val user = User()
             user.setUsername(username)
             user.setPassword(password)
             if (w != null) {
                 user.setWeight(w)
             }
             if (h != null) {
                 user.setHeight(h)
             }
             if (gw != null) {
                 user.setGoalWeight(gw)
             }
              user.setGender(gender)
             user.setChoice(weight_choice)
              if (findUser(user)) {
                  Toast.makeText(activity, "User is already registered", Toast.LENGTH_SHORT).show()
              } else {
                 LoginActivity.fitnessRepository.addUserTask(user);
                  Toast.makeText(activity, "Succesfully registered!", Toast.LENGTH_SHORT).show()
                  toTheLoginFragment();
              }
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
            if (usr.getUsername().equals(user.getUsername())) return true
        }
        return false
    }


    }
