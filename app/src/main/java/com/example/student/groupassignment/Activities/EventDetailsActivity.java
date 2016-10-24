package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Event;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Pengi on 24/10/2016.
 */

public class EventDetailsActivity  extends AppCompatActivity implements View.OnClickListener{
    private TextView title;
    private EditText description;
    private EditText tutorial;
    private EditText owner;
    private Button save, delete;

    private String name, aDesc, aTute, aOwner, date, id;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);

        title = (TextView) findViewById(R.id.eventTitle);
        description = (EditText) findViewById(R.id.addEventDescription);
        tutorial = (EditText) findViewById(R.id.addTuteName);
        owner = (EditText) findViewById(R.id.activityOwnerText);
        save = (Button) findViewById(R.id.saveEventChanges);
        delete = (Button) findViewById(R.id.deleteEventButton);

        delete.setOnClickListener(this);
        save.setOnClickListener(this);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        aDesc = intent.getStringExtra("Description");
        aTute = intent.getStringExtra("Tutorial");
        aOwner = intent.getStringExtra("Owner");
        date = intent.getStringExtra("Date");
        id = intent.getStringExtra("ObjectID");

        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        Date dueDate = null;
        try {
            dueDate = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long epoch = dueDate.getTime();

        CalendarView simpleCalendarView = (CalendarView) findViewById(R.id.calendarView2); // get the reference of CalendarView
        simpleCalendarView.setDate(epoch); // set selected date 22 May 2016 in milliseconds

        title.setText(name);
        description.setText(aDesc,TextView.BufferType.EDITABLE);
        tutorial.setText(aTute,TextView.BufferType.EDITABLE);
        owner.setText(aOwner,TextView.BufferType.EDITABLE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.saveEventChanges:
                break;
            case R.id.deleteEventButton:
                Event curEvent = Backendless.Persistence.of( Event.class ).findById( id );
                Long result = Backendless.Persistence.of( Event.class ).remove( curEvent );
                break;
        }
    }
}
