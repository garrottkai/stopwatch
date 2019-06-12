package com.kaigarrott.stopwatch;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.kaigarrott.stopwatch.data.TimeDatabase;
import com.kaigarrott.stopwatch.data.TimeEntry;

import java.util.List;

public class TimesViewModel extends AndroidViewModel {

    private LiveData<List<TimeEntry>> times;

    public TimesViewModel(Application application) {
        super(application);
        TimeDatabase db = TimeDatabase.getInstance(this.getApplication());
        times = db.timeDao().getAll();
    }

    public LiveData<List<TimeEntry>> getTimes() {
        return times;
    }
}
