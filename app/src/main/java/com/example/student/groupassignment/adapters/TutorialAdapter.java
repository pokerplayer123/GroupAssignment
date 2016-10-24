package com.example.student.groupassignment.adapters;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Tutorial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 23/10/2016.
 * An adapter that fills a view with Tutorial objects as input data
 */

public class TutorialAdapter extends RecyclerView.Adapter<TutorialAdapter.ViewHolder>{
    private Context context;
    private List<Tutorial> tuteList = new ArrayList<>();

    public TutorialAdapter (Context context) {
        this.context = context;
    }
    @Override
    public TutorialAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tutorial, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TutorialAdapter.ViewHolder holder, int position) {
        Tutorial t = tuteList.get(position);
        holder.name.setText(t.getTutorial());
        holder.description.setText(t.getDescription());
        holder.time.setText(t.getTime().toString());
    }

    @Override
    public int getItemCount() {
        return tuteList.size();
    }

    public void addTuteList(List<Tutorial> list) {
        tuteList.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name, description, time;
        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tuteName);
            description = (TextView) itemView.findViewById(R.id.tuteDesc);
            time = (TextView) itemView.findViewById(R.id.tuteTime);
        }
    }
}
