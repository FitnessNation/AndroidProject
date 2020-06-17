package com.example.fitnessnation;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MealDao {

    @Insert
    public void addMeal(Meal meal);

    @Query("select * from meals")
    public List<Meal> getMeals();

    @Delete
    public void deleteUser(Meal meal);

    @Insert
    void insertAll(Meal... meals);
}