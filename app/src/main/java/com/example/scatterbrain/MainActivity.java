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

            Toast.makeText(this, String.format("Hello - %d",l) , Toast.LENGTH_SHORT).show();

        });

        String stime = String.valueOf(System.currentTimeMillis());


        Alarm s = new Alarm(1, 5, 10, "Free Sheba");
        alarmList.add(s);


        s = new Alarm(2, 5, 10, "Off the boiler");
        alarmList.add(s);

    }

    public void refreshDataset() {
        //   helper.readAll(this, alarmList);
        adapter.notifyDataSetChanged();
    }


}











