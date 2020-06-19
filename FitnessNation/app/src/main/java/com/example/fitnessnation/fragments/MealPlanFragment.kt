package com.example.fitnessnation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.Meal
import com.example.fitnessnation.R
import com.example.fitnessnation.RecyclerViewAdapter
import com.example.fitnessnation.activitites.BottomNavigationActivity

class MealPlanFragment : Fragment() {

    private var meals: List<Meal>? = null
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? =null
    private var adapter: RecyclerViewAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_addmeal, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        BottomNavigationActivity.fitnessRepository.mealInsertTask(Meal.populateData())
        if(!BottomNavigationActivity.user.choice)//if he/she wants to lose weight show him/her weight loss meals
        {
            Toast.makeText(activity,"loose",Toast.LENGTH_LONG)
            meals= BottomNavigationActivity.fitnessRepository.getWLossMealsTask();
        }
        else
        {
            Toast.makeText(activity,"gain",Toast.LENGTH_LONG)
            meals= BottomNavigationActivity.fitnessRepository.getWGainMealsTask();
        }


        recyclerView = view.findViewById(R.id.recyclerview)
        gridLayoutManager =GridLayoutManager(activity,3)
        recyclerView?.setLayoutManager(gridLayoutManager )
        adapter = RecyclerViewAdapter(meals)
        recyclerView?.setAdapter(adapter)
    }




}
