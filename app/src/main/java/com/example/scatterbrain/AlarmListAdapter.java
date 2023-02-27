package com.example.scatterbrain;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by User on 3/14/2017.
 */

public class AlarmListAdapter extends ArrayAdapter<Alarm> {

    //private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView id;
        TextView start;
        TextView stop;
        TextView description;
    }

    /**
     * Default constructor for the StockListAdapter
     *
     * @param context
     * @param resource
     * @param objects
     */
    public AlarmListAdapter(Context context, int resource, ArrayList<Alarm> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the persons information
        int id =  getItem(position).getId();
        long start =  getItem(position).getStart();
        long stop = getItem(position).getStop();
        String description = getItem(position).getDescription();

        //Create the alarm object with the information
        Alarm alarm = new Alarm(id, start,stop, description);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();

            holder.id = convertView.findViewById(R.id.textView_id);
            holder.start = convertView.findViewById(R.id.textView_start);
            holder.stop = convertView.findViewById(R.id.textView_stop);
            holder.description = convertView.findViewById(R.id.textView_description);

            result = convertView;

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.id.setText(Integer.toString(alarm.getId()));

        String s = Long.toString(alarm.getStart());
        holder.start.setText(Long.toString(alarm.getStart()));
        holder.stop.setText(Long.toString(alarm.getStop()));
        holder.description.setText(alarm.getDescription());

        return convertView;
    }
}

























