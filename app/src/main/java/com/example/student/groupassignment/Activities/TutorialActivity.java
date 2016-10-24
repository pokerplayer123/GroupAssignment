package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.student.groupassignment.R;

/**
 * Created by Pengi on 22/10/2016.
 */

public class TutorialActivity extends AppCompatActivity  implements View.OnClickListener {
    private Button addClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        addClass.findViewById(R.id.addClassButton);
        addClass.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent AddTutorialActivity = new Intent(TutorialActivity.this, AddTutorialActivity.class);
        TutorialActivity.this.startActivity(AddTutorialActivity);
    }
}
