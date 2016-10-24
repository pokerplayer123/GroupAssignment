package com.example.student.groupassignment.Activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.student.groupassignment.R;

import java.util.Calendar;

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
        dueTime = (EditText) findViewById(R.id.addDueTime);

        add.setOnClickListener(this);
        dueDate.setOnClickListener(this);
        dueTime.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        final Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);
        TimePickerDialog mTimePicker;

        switch (view.getId()) {
            case R.id.addEventButton:
                break;
            case R.id.addDueDate:
                break;
            case R.id.addDueTime:
                mTimePicker = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        dueTime.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Due Time");
                mTimePicker.show();
                break;
        }
    }
}
