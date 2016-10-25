package com.example.student.groupassignment.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;

import com.backendless.exceptions.BackendlessFault;
import com.example.student.groupassignment.Backendless.BackendSettings;
import com.backendless.Backendless;
import com.example.student.groupassignment.Backendless.BackendSettings;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Tutorial;

/**
 * Created by Pengi on 23/10/2016.
 */

public class AddTutorialActivity  extends AppCompatActivity  implements View.OnClickListener{
    private Button addTute;
    private EditText startTime, endTime, name, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Backendless.initApp( this, BackendSettings.app_id, BackendSettings.SECRET_KEY, BackendSettings.appVersion);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtutorial);
        addTute = (Button) findViewById(R.id.addTuteButton);
        startTime = (EditText) findViewById(R.id.startTimeField);
        endTime = (EditText) findViewById(R.id.endTimeField);
        name = (EditText) findViewById(R.id.tuteName);
        description = (EditText) findViewById(R.id.tuteDescription);

        addTute.setOnClickListener(this);
        startTime.setOnClickListener(this);
        endTime.setOnClickListener(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        switch (view.getId()) {
            case R.id.addTuteButton:
                addTutorial();
                Intent i = new Intent(this, HomeActivity.class);
                startActivity(i);
                break;
            case R.id.startTimeField:
                //Calendar mcurrentTime = Calendar.getInstance();
                //int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                // int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        startTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Start Time");
                mTimePicker.show();
                break;
            case R.id.endTimeField:
                mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        endTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select End Time");
                mTimePicker.show();
                break;

        }
    }

    public void addTutorial()
    {
        Tutorial Tutorial = new Tutorial();
        String desc = description.getText().toString();
        String tutorialName = name.getText().toString();
        Tutorial.setDescription(desc);
        Tutorial.setTutorial(tutorialName);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = sdf.parse(startTime.getText().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tutorial.setTime(date);

        Backendless.Persistence.save(Tutorial, new AsyncCallback<com.example.student.groupassignment.entities.Tutorial>() {
            @Override
            public void handleResponse(Tutorial response) {

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });

    }
}
