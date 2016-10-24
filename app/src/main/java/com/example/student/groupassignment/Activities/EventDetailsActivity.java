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
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.example.student.groupassignment.Backendless.BackendSettings;
import com.example.student.groupassignment.Backendless.LoadingCallback;
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
    private CalendarView simpleCalendarView;

    private String name, aDesc, aTute, aOwner, date, id;
    private java.util.Date eventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventdetails);
        Backendless.initApp( this, BackendSettings.app_id, BackendSettings.SECRET_KEY, BackendSettings.appVersion);

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
                updateEvent();
                Intent HomeActivity = new Intent(this, com.example.student.groupassignment.Activities.HomeActivity.class);
                startActivity(HomeActivity);
                break;
            case R.id.deleteEventButton:
                deleteEvent();
                Intent deleteActivity = new Intent(this, com.example.student.groupassignment.Activities.HomeActivity.class);
                startActivity(deleteActivity);

        }
    }
    public void saveEvent()
    {
        Event Event = new Event();
        name = title.getText().toString();
        aDesc = description.getText().toString();
        Event.setName(name);
        Event.setDescription(aDesc);

        Backendless.Persistence.save(Event, new AsyncCallback<com.example.student.groupassignment.entities.Event>() {
            @Override
            public void handleResponse(Event response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }

    public void updateEvent(){
        Event curEvent = Backendless.Persistence.of( Event.class ).findById( id );
            name = title.getText().toString();
            aDesc = description.getText().toString();
            curEvent.setName(name);
            curEvent.setDescription(aDesc);

            Backendless.Persistence.save(curEvent, new AsyncCallback<com.example.student.groupassignment.entities.Event>() {
                @Override
                public void handleResponse(Event response) {

                }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });

    }


    public void deleteEvent()
    {
        Event curEvent = Backendless.Persistence.of( Event.class ).findById( id );
        curEvent.remove();

    }
}
