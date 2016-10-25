package com.example.student.groupassignment.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.example.student.groupassignment.Backendless.LoadingCallback;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.adapters.TutorialAdapter;
import com.example.student.groupassignment.entities.Tutorial;
import com.example.student.groupassignment.entities.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pengi on 22/10/2016.
 */

public class TutorialActivity extends AppCompatActivity {
    private Button addClass;
    private BackendlessCollection<Tutorial> Tutorial;
    private TutorialAdapter adapter;
    private List<Tutorial> list= new ArrayList<>();
    private boolean isLoadingItems = false;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorials);

        //Set Adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new TutorialAdapter(this);
        recyclerView.setAdapter(adapter);


        // Query object for searching the backendless datastore to retrieve information
        QueryOptions queryOptions = new QueryOptions();

        BackendlessDataQuery query = new BackendlessDataQuery(queryOptions);
        // Retrieve data based from the "Tutorial" table
        Backendless.Persistence.of(Tutorial.class).find(query, new LoadingCallback<BackendlessCollection<Tutorial>>(this, getString(R.string.loading_students)) {
            @Override
            public void handleResponse(BackendlessCollection<Tutorial> tuteBackendlessCollection) {
                Tutorial = tuteBackendlessCollection;
                addMoreItems(tuteBackendlessCollection);


                super.handleResponse(tuteBackendlessCollection);
            }
        });

        addClass = (Button) findViewById(R.id.addClass);
        addClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, AddTutorialActivity.class);
                TutorialActivity.this.startActivity(intent);
            }
        });

        //addClass.findViewById(R.id.addTuteButton);
        //addClass.setOnClickListener(this);
    }

    /*@Override
    public void onClick(View view) {
        Intent AddTutorialActivity = new Intent(TutorialActivity.this, AddTutorialActivity.class);
        TutorialActivity.this.startActivity(AddTutorialActivity);
    }*/

    private void addMoreItems(BackendlessCollection<Tutorial> nextPage) {
        list.addAll(nextPage.getCurrentPage());
        adapter.addTuteList(list);
    }
}
