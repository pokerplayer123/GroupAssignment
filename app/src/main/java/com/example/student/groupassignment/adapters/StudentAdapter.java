package com.example.student.groupassignment.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.example.student.groupassignment.Activities.StudentListActivity;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 24/10/2016.
 * Adapter for recycler view
 */

public class StudentAdapter extends ArrayAdapter<Users> {

private LayoutInflater mInflater;
private int mResource;

public StudentAdapter( Context context, int resource, List<Users> userList)
        {
        super( context, resource, userList);
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);


        }

@Override
public View getView( int pos, View convertView, ViewGroup parent)
        {
        View view = convertView == null ? mInflater.inflate( mResource, parent, false ) : convertView;

        TextView username = (TextView) view.findViewById( R.id.name );
        TextView emailView = (TextView) view.findViewById( R.id.email);
        TextView ZID = (TextView) view.findViewById( R.id.zid);
        Users user = getItem( pos);

        username.setText( user.getName() );
        emailView.setText( user.getEmail());
        ZID.setText( user.getZid());


        return view;


        }

        }








