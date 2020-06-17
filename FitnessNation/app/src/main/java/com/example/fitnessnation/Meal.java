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

    public Meal(String name, int imagePath, int calorie, String recipe) {
        this.name=name;
        this.imagePath = imagePath;
        this.calorie = calorie;
        this.recipe = recipe;
    }

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "meal_name")
    private String name;

    @ColumnInfo(name = "meal_image")
    private int imagePath;

    @ColumnInfo(name = "meal_calorie")
    private int calorie=0;

    @ColumnInfo(name = "meal_recipe")
    private String recipe;



    public String getName() { return name; }
    public int getImagePath() {
        return imagePath;
    }
    public int getCalorie() { return calorie; }
    public String getRecipe() {return recipe; }


    public void setName(String name) {
        this.name = name;
    }
    public void setImagePath(int imagePath) {this.imagePath=imagePath; }
    public void setCalorie(int calorie) {this.calorie=calorie; }
    public void setRecipe(String recipe) { this.recipe=recipe; }

    public static Meal[] populateData() {
        return new Meal[] {
                new Meal("Green tea", R.drawable.green_tea,120, "Cook it 10 minutes"),
                new Meal("Grapefruit", R.drawable.grapefruitjpg,10, "Peal it")

        };
    }

}
