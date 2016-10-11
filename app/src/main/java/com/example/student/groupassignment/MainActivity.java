package com.example.student.groupassignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.backendless.Backendless;

public class MainActivity extends AppCompatActivity {

    public static final String app_id="GroupAssignment";
    public static final String SECRET_KEY="7E171BA1-8523-21C9-FFF1-A353B6944A00";
    public static final String appVersion="v1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Backendless.initApp( this, app_id, SECRET_KEY, appVersion);
    }
}
