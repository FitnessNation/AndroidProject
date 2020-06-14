package com.example.fitnessnation.fragments

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.fitnessnation.R
import com.example.fitnessnation.User
import com.example.fitnessnation.activitites.BottomNavigationActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_statistics.*

class StatisticsFragment : Fragment() {
    private var user: User? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_statistics, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user= arguments?.getSerializable("user") as User?

        name.text= user?.getUsername() ?: "nothing";
      //  Toast.makeText(activity, user!!.getUsername(), Toast.LENGTH_SHORT).show()




    }
}
