package com.example.student.groupassignment.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.example.student.groupassignment.Activities.StudentListActivity;
import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.User;

import java.util.List;

import static weborb.util.ThreadContext.context;

/**
 * Created by Aaron on 24/10/2016.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{
private List<User> studentList;
public Context mContext;

public static class ViewHolder extends RecylcerView.ViewHolder{
    public TextView email, zid, name;

    public ViewHolder(View view) {
        super(view);
        email = (TextView) view.findViewById(R.id.email);
        zid = (TextView) view.findViewById(R.id.zid);
        name = (TextView) view.findViewById(R.id.name);
    }
}

    public StudentAdapter(List<User> studentList, Context context) {
        this.studentList = studentList;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_student_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = studentList.get(position);
        holder.name.setText(user.getName());
        holder.zid.setText(user.getZid());
        holder.email.setText(user.getEmail());

    }
    @Override
    public int getItemCount(){return studentList.size();}
}








