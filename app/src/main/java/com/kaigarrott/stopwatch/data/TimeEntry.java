package com.kaigarrott.stopwatch.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "time")
public class TimeEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int timestamp;
    private int value;

    @Ignore
    public TimeEntry(int value) {
        this.value = value;
    }

    public TimeEntry(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
