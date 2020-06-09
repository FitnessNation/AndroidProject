package com.example.fitnessnation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fitnessnation.R
import kotlinx.android.synthetic.main.fragment_logo.*

class LogoFragment : Fragment() {
    companion object {
        fun newInstance() = LogoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toast = Toast.makeText(this.context, "This is F1A2", Toast.LENGTH_SHORT).show()
        btn_start.setOnClickListener {
            //toTheSecondFragment()
            val toast = Toast.makeText(this.context, "This is F2A2", Toast.LENGTH_SHORT).show()
        }


    }
}
/*fun toTheSecondFragment()
{
    val transaction = fragmentManager!!.beginTransaction()
    transaction.replace(R.id.primary_frame_s_session,ThirdFragment.newInstance())
    transaction.addToBackStack(ThirdFragment.toString())
    transaction.commit()
}*/