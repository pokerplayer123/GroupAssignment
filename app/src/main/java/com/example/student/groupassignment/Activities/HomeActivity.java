package com.example.student.groupassignment.Activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.AbsListView;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.example.student.groupassignment.Backendless.LoadingCallback;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.adapters.EventAdapter;
import com.example.student.groupassignment.entities.Event;
import com.example.student.groupassignment.entities.Tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Pengi on 21/10/2016.
 */

public class HomeActivity  extends ListActivity implements View.OnClickListener {
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

        BackendlessDataQuery query = new BackendlessDataQuery( queryOptions);

        Backendless.Persistence.of( Event.class ).find( query, new LoadingCallback<BackendlessCollection<Event>>(this, getString( R.string.loading_events ))
        {
            @Override
            public void handleResponse(BackendlessCollection<Event> eventsBackendlessCollection) {
                events = eventsBackendlessCollection;
                addMoreItems(eventsBackendlessCollection);

                super.handleResponse(eventsBackendlessCollection);
            }
        });

        ListView list = (ListView) findViewById( android.R.id.list );
        list.setOnScrollListener( new AbsListView.OnScrollListener()
        {
            @Override
            public void onScrollStateChanged( AbsListView view, int scrollState )
            {
            }
            @Override
            public void onScroll( AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (needToLoadItems(firstVisibleItem, visibleItemCount, totalItemCount)) {
                    isLoadingItems = true;

                    events.nextPage(new LoadingCallback<BackendlessCollection<Event>>(HomeActivity.this) {
                        @Override
                        public void handleResponse(BackendlessCollection<Event> nextPage) {

                            events = nextPage;
                            addMoreItems(nextPage);
                            isLoadingItems = false;
                        }
                    });
                }
            }
        });

        classButton = (ImageButton) findViewById(R.id.classButton);
        studentButton = (ImageButton) findViewById(R.id.studentButton);
        eventButton = (ImageButton) findViewById(R.id.eventButton);

        classButton.setOnClickListener(this);
        studentButton.setOnClickListener(this);
        eventButton.setOnClickListener(this);
    }
    /**
     * Determines whether more items need to be loaded as user scrolls down
     *
     * @param firstVisibleItem number of the first item visible on screen
     * @param visibleItemCount number of items visible on screen
     * @param totalItemCount   total number of items in list
     * @return true if user is about to reach the end of a list, else false
     */
    private boolean needToLoadItems( int firstVisibleItem, int visibleItemCount, int totalItemCount )
    {
        return !isLoadingItems && totalItemCount != 0 && totalItemCount - (visibleItemCount + firstVisibleItem) < visibleItemCount /2;
    }

    /**
     * Adds more items to list and notifies Android that dataset has changed.
     *
     * @param nextPage list of new items
     */
    private void addMoreItems(BackendlessCollection<Event> nextPage)
    {
        totalEvents.addAll( nextPage.getCurrentPage() );
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.classButton:
                Intent ClassActivity = new Intent(HomeActivity.this, TutorialActivity.class);
                HomeActivity.this.startActivity(ClassActivity);
                break;
            case R.id.studentButton:
                break;
            case R.id.eventButton:
                break;
        }
    }
}
