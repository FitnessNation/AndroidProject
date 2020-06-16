package com.example.fitnessnation;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "meals")
public class Meal implements Serializable {//serializable is for passing the object to the next activity


    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "meal_name")
    protected String name;

    @ColumnInfo(name = "meal_image")
    protected String imagePath;

    @ColumnInfo(name = "meal_calorie")
    protected int calorie=0;

    @ColumnInfo(name = "meal_recipe")
    protected String recipe;




    public String getMealName() { return name; }
    public String getMealImagePath() {
        return imagePath;
    }
    public int getMealCalorie() { return calorie; }
    public String getMealRecipe() {return recipe; }


    public void setMealName(String name) {
        this.name = name;
    }
    public void setMealImagePath(String imagePath) {this.imagePath=imagePath; }
    public void setMealCalorie(int calorie) {this.calorie=calorie; }
    public void setMealRecipe(String recipe) { this.recipe=recipe; }


}
