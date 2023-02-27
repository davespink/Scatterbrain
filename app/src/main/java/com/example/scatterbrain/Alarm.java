package com.example.scatterbrain;
/**
 * Created by User on 3/14/2017.
 */

public class Alarm {
    private int id;
    private long start;
    private long stop;
    private String description;

    public Alarm(int id, long start,long stop,  String description) {
        this.id = id;
        this.start = start;
        this.stop = stop;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
