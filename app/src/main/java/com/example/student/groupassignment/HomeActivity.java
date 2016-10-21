package com.example.student.groupassignment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.backendless.Backendless;

/**
 * Created by Aaron on 21/10/2016.
 */

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Backendless.initApp(this, BackendSettings.app_id, BackendSettings.SECRET_KEY, BackendSettings.appVersion);
    }
}
