package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.groupassignment.R;

/**
 * Created by Pengi on 24/10/2016.
 */

public class EventDetailsActivity  extends AppCompatActivity {
    private TextView title;
    private EditText description;
    private EditText tutorial;
    private EditText owner;

    private String name, aDesc, aTute, aOwner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);

        title = (TextView) findViewById(R.id.eventTitle);
        description = (EditText) findViewById(R.id.activityDescText);
        tutorial = (EditText) findViewById(R.id.activityTuteText);
        owner = (EditText) findViewById(R.id.activityOwnerText);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        aDesc = intent.getStringExtra("Descipriton");
        aTute = intent.getStringExtra("Tutorial");
        aOwner = intent.getStringExtra("Owner");

        title.setText(name);
        description.setText(aDesc,TextView.BufferType.EDITABLE);
        tutorial.setText(aTute,TextView.BufferType.EDITABLE);
        owner.setText(aOwner,TextView.BufferType.EDITABLE);
    }
}
