package com.example.fitnessnation;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {


    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "user_username")
    private String username;


    @ColumnInfo(name = "user_password")
    private String password;


    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {this.password = password; }
}
