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

        TextView my_id;
        TextView barcode;
        TextView description;
        TextView qty;
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
        String my_id = getItem(position).getMy_id();
        String barcode = getItem(position).getBarcode();
        String description = getItem(position).getDescription();
        String qty = getItem(position).getQty();

        //Create the person object with the information
        Alarm alarm = new Alarm(my_id, barcode, description, qty);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();

            holder.my_id = convertView.findViewById(R.id.textView_my_id);
            holder.barcode = convertView.findViewById(R.id.textView_barcode);
            holder.description = convertView.findViewById(R.id.textView_description);
            holder.qty = convertView.findViewById(R.id.textView_qty);

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

        holder.my_id.setText(alarm.getMy_id());
        holder.barcode.setText(alarm.getBarcode());
        holder.description.setText(alarm.getDescription());
        holder.qty.setText(alarm.getQty());

        return convertView;
    }
}

























