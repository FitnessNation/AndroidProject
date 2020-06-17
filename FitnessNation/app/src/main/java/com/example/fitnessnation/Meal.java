package com.example.fitnessnation;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.Contract;

import java.io.Serializable;

@Entity(tableName = "meals")
public class Meal  {//serializable is for passing the object to the next activity

    public Meal(String name, String imagePath, int calorie, String recipe) {
        this.name=name;
        this.imagePath = imagePath;
        this.calorie = calorie;
        this.recipe = recipe;
    }

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

    public static Meal[] populateData() {
        return new Meal[] {
                new Meal("Ot Berries", "R.drawable.oatmeal_berries.jpg",120, "Cook it 10 minutes"),
                new Meal("Graefruit", "R.drawable.grapefruitjpg.jpg",10, "Peal it")

        };
    }

}
