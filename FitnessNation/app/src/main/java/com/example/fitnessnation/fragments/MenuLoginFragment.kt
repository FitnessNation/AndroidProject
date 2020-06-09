package com.example.fitnessnation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.fitnessnation.R
import kotlinx.android.synthetic.main.fragment_menu_login.*


class MenuLoginFragment : Fragment() {


        companion object {
            fun newInstance() = MenuLoginFragment()
        }

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_menu_login, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            btn_login.setOnClickListener {
                toTheLoginFragment()

            }
        }



        fun toTheLoginFragment()
        {
            val transaction = fragmentManager!!.beginTransaction()
            transaction.replace(R.id.primary_frame_s_session,LogInFragment.newInstance())
            transaction.addToBackStack(LogInFragment.toString())
            transaction.commit()
        }

}
