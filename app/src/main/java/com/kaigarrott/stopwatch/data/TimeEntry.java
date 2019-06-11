package com.kaigarrott.stopwatch.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "time")
public class TimeEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String value;

    @Ignore
    public TimeEntry(String value) {
        this.value = value;
    }

    public TimeEntry(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
