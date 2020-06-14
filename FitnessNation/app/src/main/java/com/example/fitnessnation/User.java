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
    private int weight=0;

    @ColumnInfo(name = "user_height")
    private int height=0;


    @ColumnInfo(name = "user_password")
    private String password;

    @ColumnInfo(name = "user_gender")
    private String gender="nothing";


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getWeight() { return weight; }
    public int getHeight() {return height; }
    public String getGender() {return gender; }


    public void setUsername(String username) {
        this.username = username;
    }
    public void setGender(String gender) {this.gender=gender; }
    public void setPassword(String password) {this.password = password; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setHeight(int height) {this.height=height; }


}
