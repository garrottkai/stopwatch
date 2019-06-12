package com.kaigarrott.stopwatch.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TimeDao {

    @Query("SELECT * FROM time ORDER BY timestamp ASC")
    LiveData<List<TimeEntry>> getAll();

    @Query("SELECT * FROM time WHERE id = :id")
    LiveData<TimeEntry> getById(int id);

    @Insert
    void insert(TimeEntry timeEntry);

    @Update
    void update(TimeEntry timeEntry);

    @Delete
    void delete(TimeEntry timeEntry);

}
