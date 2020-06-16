package com.example.fitnessnation;

import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class,Meal.class}, version = 5, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
//    public abstract MealDao mealDao();

}
