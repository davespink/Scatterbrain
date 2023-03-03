package com.example.scatterbrain;


import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import android.view.ViewGroup;

import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ArrayList<Alarm> alarmList;
    AlarmListAdapter adapter;

    Alarm thisAlarm;

    final Handler handler = new Handler();


    Timer timer;
    TimerTask timerTask;

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

            //thisAlarm = alarmList.get(position);
            //     Toast.makeText(this, String.format("Hello - %s",thisAlarm.getDescription()) , Toast.LENGTH_SHORT).show();

            // extract the id field at this position
            View thisChild = ((ViewGroup) view).getChildAt(0);
            String s = (String) ((TextView) thisChild).getText();
            long lId = Long.parseLong(s);
            TextView v = (TextView) findViewById(R.id.description);
            thisAlarm = null;
            for (int i = 0; i < alarmList.size(); i++) {
                if (alarmList.get(i).getId() == lId) {
                    thisAlarm = alarmList.get(i);
                    break;
                }
            }

            if (thisAlarm == null) {
                 Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            } else {
                v.setText(thisAlarm.getDescription());
            }




        });


        Alarm s = new Alarm(System.currentTimeMillis(), 0, 0, "Free Sheba");
        alarmList.add(s);

        startTimer();

    }

    public void actionButton(View v) {
        String viewID = getResources().getResourceName(v.getId());
        int l = viewID.length();
        viewID = viewID.substring(l - 1, l);
        String thisKey = viewID;



        switch (thisKey) {
            case "s": {
                TextView vDesc = (TextView) findViewById(R.id.description);
                if (thisAlarm != null) {
                    thisAlarm.setDescription(vDesc.getText().toString());
                } else {
                    Toast.makeText(this, "Null alarm", Toast.LENGTH_SHORT).show();
                }
                ;
                break;
            }

            case "n": {
                int now = (int) System.currentTimeMillis();
                Alarm s = new Alarm(now, now, now+1000*10, "New alarm 10 seconds");
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






    @Override
    protected void onResume() {
        super.onResume();

        //onResume we start our timer so it can start when the app comes from the background
        //  startTimer();
    }

    public void startTimer() {
        //set a new Timer
        timer = new Timer();

        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        timer.schedule(timerTask, 5000, 10000); //
    }

    public void stoptimertask( ) {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {

        timerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                handler.post(new Runnable() {
                    public void run() {
                        //get the current timeStamp
                        /*
                        Calendar calendar = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
                        final String strDate = simpleDateFormat.format(calendar.getTime());

                        //show the toast
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(getApplicationContext(), strDate, duration);
                        toast.show();

                         */

                        refreshDataset();

                    }
                });
            }
        };


    }












}











