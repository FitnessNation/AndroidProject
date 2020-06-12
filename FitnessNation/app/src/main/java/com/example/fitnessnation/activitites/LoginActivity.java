package com.example.fitnessnation.activitites;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import com.example.fitnessnation.AppDatabase;
import com.example.fitnessnation.R;
import com.example.fitnessnation.fragments.MenuLoginFragment;

public class LoginActivity extends AppCompatActivity {

    public static AppDatabase appDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"userdatabase").allowMainThreadQueries().build();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.primary_frame_s_session, MenuLoginFragment.newInstance()).commitNow();
        }
    }





}
