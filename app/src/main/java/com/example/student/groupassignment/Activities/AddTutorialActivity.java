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
                Tutorial tute = new Tutorial();
                tute.setDescription(description.getText().toString());
                tute.setTutorial(name.getText().toString());

                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date date = null;
                try {
                    date = sdf.parse(startTime.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tute.setTime(date);
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
}
