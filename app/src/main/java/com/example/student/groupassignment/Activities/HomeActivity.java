package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.student.groupassignment.R;

/**
 * Created by Pengi on 21/10/2016.
 */

public class HomeActivity  extends AppCompatActivity implements View.OnClickListener{
    private ImageButton classButton;
    private ImageButton studentButton;
    private ImageButton eventButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        classButton = (ImageButton) findViewById(R.id.classButton);
        studentButton = (ImageButton) findViewById(R.id.studentButton);
        eventButton = (ImageButton) findViewById(R.id.eventButton);

        classButton.setOnClickListener(this);
        studentButton.setOnClickListener(this);
        eventButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.classButton:
                Intent ClassActivity = new Intent(this, TutorialActivity.class);
                startActivity(ClassActivity);
                break;
            case R.id.studentButton:
                break;
            case R.id.eventButton:
                break;
        }
    }
}
