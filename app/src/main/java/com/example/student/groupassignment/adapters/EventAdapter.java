package com.example.student.groupassignment.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.student.groupassignment.R;
import com.example.student.groupassignment.entities.Event;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Aaron on 23/10/2016.
 */

public class EventAdapter extends ArrayAdapter<Event> {

    private LayoutInflater mInflater;
    private int mResource;

    public EventAdapter( Context context, int resource, List<Event> eventList)
    {
        super( context, resource, eventList);
        mResource = resource;
        mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView( int pos, View convertView, ViewGroup parent)
    {
        View view = convertView == null ? mInflater.inflate( mResource, parent, false ) : convertView;

        TextView eventNameView = (TextView) view.findViewById( R.id.eventName );
        TextView descriptionView = (TextView) view.findViewById( R.id.description);
        TextView eventTimeView = (TextView) view.findViewById( R.id.dateTime);
        Event item = getItem( pos);

        eventNameView.setText( item.getName() );
        descriptionView.setText( item.getDescription());
        eventTimeView.setText( item.getEventTime().toString());


        return view;
    }


}


