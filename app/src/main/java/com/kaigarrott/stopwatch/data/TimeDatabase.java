package com.kaigarrott.stopwatch.data;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;
import android.content.Context;

@Database(entities = TimeEntry.class, version = 1, exportSchema = false)
public abstract class TimeDatabase extends RoomDatabase {

    private static TimeDatabase sInstance;
    private static final Object LOCK = new Object();
    private static final String DB_NAME = "times";

    public static TimeDatabase getInstance(Context context) {
        if(sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(), TimeDatabase.class, TimeDatabase.DB_NAME).build();
            }
        }
        return sInstance;
    }

    public abstract TimeDao timeDao();
}
