package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.backendless.Backendless;
import com.example.student.groupassignment.Backendless.BackendSettings;
import com.example.student.groupassignment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Backendless.initApp( this, BackendSettings.app_id, BackendSettings.SECRET_KEY, BackendSettings.appVersion);
        if (Backendless.UserService.loggedInUser() == "") {
            Intent LoginIntent = new Intent(this, LoginActivity.class);
            startActivity(LoginIntent);
        }
        else{
            Backendless.UserService.loggedInUser();
               Intent HomeActivity = new Intent(this, com.example.student.groupassignment.Activities.HomeActivity.class);
                startActivity(HomeActivity);
            }

        }
    }
