package com.kaigarrott.stopwatch.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "time")
public class TimeEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private long timestamp;
    private long value;

    @Ignore
    public TimeEntry(long timestamp, long value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public TimeEntry(int id, long timestamp, long value) {
        this.id = id;
        this.timestamp = timestamp;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public long getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
