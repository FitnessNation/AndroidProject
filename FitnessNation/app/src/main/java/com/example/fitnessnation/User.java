package com.example.fitnessnation;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {//serializable is for passing the object to the next activity


    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "user_username")
    private String username;


    @ColumnInfo(name = "user_weight")
    private double weight;

    @ColumnInfo(name = "user_height")
    private double height=0.0;


    @ColumnInfo(name = "user_password")
    private String password;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public double getWeight() { return weight; }
    public double getHeight() {return height; }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {this.password = password; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setHeight(double height) {this.height=height; }


}
