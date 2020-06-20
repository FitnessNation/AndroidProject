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

class ProfileFragment : Fragment() {
    private var user: User? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user=BottomNavigationActivity.user;
      // user= arguments?.getSerializable("user") as User?
        weight.text= user?.getWeight().toString();
        height.text= user?.getHeight().toString();
        tv_username.text= user?.getUsername();

        if(user?.getGender()=="man")
        {
            imageOfGender.setImageResource(R.drawable.man)
        }
        else
        {
            imageOfGender.setImageResource(R.drawable.woman)
        }

      //  weight.text=a;
    }
}
