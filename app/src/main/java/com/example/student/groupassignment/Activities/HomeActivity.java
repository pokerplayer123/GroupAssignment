package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.example.student.groupassignment.Backendless.LoadingCallback;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.adapters.EventAdapter;
import com.example.student.groupassignment.entities.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pengi on 21/10/2016.
 */

public class HomeActivity  extends AppCompatActivity implements View.OnClickListener{
    private ImageButton classButton;
    private ImageButton studentButton;
    private ImageButton eventButton;
    private BackendlessCollection<Event> events;
    private List<Event> totalEvents = new ArrayList<>();
    private boolean  isLoadingItems = false;
    private EventAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);

        adapter = new EventAdapter( HomeActivity.this, R.layout.list_item_event, totalEvents);
        setListAdapter( adapter );

        QueryOptions queryOptions = new QueryOptions();
        queryOptions.setRelated( Arrays.asList( "Event"));

        BackendlessDataQuery query = new BackendlessDataQuery( queryOptions);

        Backendless.Data.of( Event.class ).find( query, new LoadingCallback<BackendlessCollection<Event>>(this, getString( R.string.loading_events )))

        classButton = (ImageButton) findViewById(R.id.classButton);
        studentButton = (ImageButton) findViewById(R.id.studentButton);
        eventButton = (ImageButton) findViewById(R.id.eventButton);

        classButton.setOnClickListener(this);
        studentButton.setOnClickListener(this);
        eventButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.classButton:
                Intent ClassActivity = new Intent(this, TutorialActivity.class);
                startActivity(ClassActivity);
                break;
            case R.id.studentButton:
                break;
            case R.id.eventButton:
                break;
        }
    }
}
