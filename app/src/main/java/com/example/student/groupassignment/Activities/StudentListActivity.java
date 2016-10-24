package com.example.student.groupassignment.Activities;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.persistence.BackendlessDataQuery;
import com.backendless.persistence.QueryOptions;
import com.example.student.groupassignment.Backendless.LoadingCallback;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.adapters.EventAdapter;
import com.example.student.groupassignment.adapters.StudentAdapter;
import com.example.student.groupassignment.entities.Event;
import com.example.student.groupassignment.entities.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 24/10/2016.
 * The StudentListActivity. This the list of Students that have registered to the app
 */

public class StudentListActivity extends ListActivity {
    private BackendlessCollection<Users> users;
    private StudentAdapter adapter;
    private List<Users> totalUsers = new ArrayList<>();
    private boolean isLoadingItems = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        adapter = new StudentAdapter( StudentListActivity.this, R.layout.list_item_user, totalUsers);
        setListAdapter( adapter );


        // Query object for searching the backendless datastore to retrieve information
        QueryOptions queryOptions = new QueryOptions();
        String whereClause = "Type = 'Student'";

        BackendlessDataQuery query = new BackendlessDataQuery(queryOptions);
        query.setWhereClause(whereClause);
        // Retrieve data based from the "User" table
        Backendless.Persistence.of(Users.class).find(query, new LoadingCallback<BackendlessCollection<Users>>(this, getString(R.string.loading_students)) {
            @Override
            public void handleResponse(BackendlessCollection<Users> UsersBackendlessCollection) {
                users = UsersBackendlessCollection;
                addMoreItems(UsersBackendlessCollection);


                super.handleResponse(UsersBackendlessCollection);
            }
        });

        ListView list = (ListView) findViewById(android.R.id.list);
        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (needToLoadItems(firstVisibleItem, visibleItemCount, totalItemCount)) {
                    isLoadingItems = true;

                    users.nextPage(new LoadingCallback<BackendlessCollection<Users>>(StudentListActivity.this) {
                        @Override
                        public void handleResponse(BackendlessCollection<Users> nextPage) {

                            users = nextPage;
                            addMoreItems(nextPage);
                            isLoadingItems = false;
                        }
                    });
                }
            }
        });
    }

        /**
         * Determines whether more items need to be loaded as user scrolls down
         *
         * @param firstVisibleItem number of the first item visible on screen
         * @param visibleItemCount number of items visible on screen
         * @param totalItemCount   total number of items in list
         * @return true if user is about to reach the end of a list, else false
         */
        private boolean needToLoadItems(int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            return !isLoadingItems && totalItemCount != 0 && totalItemCount - (visibleItemCount + firstVisibleItem) < visibleItemCount / 2;
        }

        /**
         * Adds more items to list and notifies Android that dataset has changed.
         *
         * @param nextPage list of new items
         */
        private void addMoreItems(BackendlessCollection<Users> nextPage) {
            totalUsers.addAll(nextPage.getCurrentPage());
            adapter.notifyDataSetChanged();
        }
    }
