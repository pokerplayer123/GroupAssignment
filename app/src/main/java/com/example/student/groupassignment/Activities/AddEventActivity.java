package com.example.student.groupassignment.Activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Event;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Pengi on 25/10/2016.
 */

public class AddEventActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText title, description, tutorial, dueDate, dueTime;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addevent);

        add = (Button) findViewById(R.id.addEventButton);
        description = (EditText) findViewById(R.id.addEventDescription);
        tutorial = (EditText) findViewById(R.id.addTuteName);
        title = (EditText) findViewById(R.id.addEventTitle);
        dueDate = (EditText) findViewById(R.id.addDueDate);
        dueDate.setText("MM/DD/YYYY");
        dueTime = (EditText) findViewById(R.id.addDueTime);

        add.setOnClickListener(this);
        dueDate.setOnClickListener(this);
        dueTime.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        final Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;

        switch (view.getId()) {
            case R.id.addEventButton:
                saveEvent();
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);


                break;
            case R.id.addDueDate:
                dueDate.clearComposingText();
                break;
            case R.id.addDueTime:
                dueTime.clearComposingText();
                mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        dueTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Due Time HH/MM");
                mTimePicker.show();
                break;
        }
    }
    public void saveEvent()
    {
        Event Event = new Event();
        String name = title.getText().toString();
        String aDesc = description.getText().toString();
        Event.setName(name);
        Event.setDescription(aDesc);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try {
            date = sdf.parse(dueDate.getText().toString() + " " + dueTime.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Event.setEventTime(date);

        Backendless.Persistence.save(Event, new AsyncCallback<com.example.student.groupassignment.entities.Event>() {
            @Override
            public void handleResponse(Event response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }

}
