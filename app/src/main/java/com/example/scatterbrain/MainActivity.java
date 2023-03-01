package com.example.scatterbrain;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Alarm> alarmList;
    AlarmListAdapter adapter;

    Alarm thisAlarm;

    //
    // see https://guides.codepath.com/android/Populating-a-ListView-with-a-CursorAdapter
    //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView mListView = findViewById(R.id.alarmList);
        alarmList = new ArrayList<>();

        adapter = new AlarmListAdapter(this, R.layout.adapter_view_layout, alarmList);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener((adapterView, view, position, l) -> {

            thisAlarm = alarmList.get(position);
            //     Toast.makeText(this, String.format("Hello - %s",thisAlarm.getDescription()) , Toast.LENGTH_SHORT).show();
            TextView v = (TextView) findViewById(R.id.description);
            v.setText(thisAlarm.getDescription());

        });

        //   String stime = String.valueOf(System.currentTimeMillis());


        Alarm s = new Alarm(1, 5, 6, "Free Sheba");
        alarmList.add(s);


        s = new Alarm(2, 5, 24, "Off the boiler");
        alarmList.add(s);

    }

    public void actionButton(View v) {
        String viewID = getResources().getResourceName(v.getId());
        int l = viewID.length();
        viewID = viewID.substring(l - 1, l);
        String thisKey = viewID;

       // Toast.makeText(this, thisAlarm.getDescription(), Toast.LENGTH_SHORT).show();

        switch(thisKey)
        {
            case "s" : {
                TextView vDesc = (TextView) findViewById(R.id.description);
                thisAlarm.setDescription(vDesc.getText().toString());
                break;
            }

            case "n" : {
                Alarm s = new Alarm(3, 5, 24, "New alarm");
                alarmList.add(s);
                break;
            }
        }




        refreshDataset();
    }

    public void onDestroy() {
        adapter.clear();

        super.onDestroy();
    }

    public void refreshDataset() {
        //   helper.readAll(this, alarmList);
        adapter.notifyDataSetChanged();
    }


}











