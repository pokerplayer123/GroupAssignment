package com.example.student.groupassignment.Activities;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

import com.example.student.groupassignment.R;

/**
 * Created by Pengi on 23/10/2016.
 */

public class AddTutorialActivity  extends AppCompatActivity  implements View.OnClickListener{
    private Button addTute;
    private EditText startTime, endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtutorial);
        addTute = (Button) findViewById(R.id.addTuteButton);
        startTime = (EditText) findViewById(R.id.startTimeField);
        endTime = (EditText) findViewById(R.id.endTimeField);

        addTute.setOnClickListener(this);
        startTime.setOnClickListener(this);
        endTime.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        switch (view.getId()) {
            case R.id.addTuteButton:
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
