package com.example.fitnessnation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitnessnation.Meal
import com.example.fitnessnation.R
import com.example.fitnessnation.Recycler
import com.example.fitnessnation.activitites.BottomNavigationActivity

class MealPlanFragment : Fragment() {

    private var meals: List<Meal>? = null
    private var recyclerView: RecyclerView? = null
    private var gridLayoutManager: GridLayoutManager? =null
    private var adapter: Recycler? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_addmeal, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       meals= BottomNavigationActivity.fitnessRepository.getMealsTask();
        recyclerView = view.findViewById(R.id.recyclerview)
        gridLayoutManager =GridLayoutManager(activity,3)
        recyclerView?.setLayoutManager(gridLayoutManager )
        adapter = Recycler(meals)
        recyclerView?.setAdapter(adapter)
       // (meals as MutableList<Meal>?)?.get(15)?.imagePath?.let { foodImage.setImageResource(it) }
    }




}
