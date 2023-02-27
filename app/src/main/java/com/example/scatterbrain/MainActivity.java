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

            Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();

        });


        Alarm s = new Alarm("1", "1", "one", "1");
        alarmList.add(s);


        s = new Alarm("2", "2", "two", "2");
        alarmList.add(s);

        s = new Alarm("3", "3", "three", "3");
        alarmList.add(s);

        s = new Alarm("4", "4", "four", "4");
        alarmList.add(s);
       s = new Alarm("1", "1", "one", "1");
        alarmList.add(s);


        s = new Alarm("2", "2", "two", "2");
        alarmList.add(s);

        s = new Alarm("3", "3", "three", "3");
        alarmList.add(s);

        s = new Alarm("4", "4", "four", "4");
        alarmList.add(s);

  s = new Alarm("1", "1", "one", "1");
        alarmList.add(s);


        s = new Alarm("2", "2", "two", "2");
        alarmList.add(s);

        s = new Alarm("3", "3", "three", "3");
        alarmList.add(s);

        s = new Alarm("4", "4", "four", "4");
        alarmList.add(s);

         s = new Alarm("1", "1", "one", "1");
        alarmList.add(s);


        s = new Alarm("2", "2", "two", "2");
        alarmList.add(s);

        s = new Alarm("3", "3", "three", "3");
        alarmList.add(s);

        s = new Alarm("4", "4", "four", "4");
        alarmList.add(s);

    }

    public void refreshDataset() {
     //   helper.readAll(this, alarmList);
        adapter.notifyDataSetChanged();
    }





}











