package com.example.student.groupassignment.Activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
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
                Event event = new Event();
                event.setName(title.getText().toString());
                event.setDescription(description.getText().toString());
                //event.setTutorial(tutorial.getText().toString());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date date = null;
                try {
                    date = sdf.parse(dueDate.getText().toString() + " " + dueTime.getText().toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                event.setEventTime(date);
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
