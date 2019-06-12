package com.kaigarrott.stopwatch;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TaskExecutors {

    private static final Object LOCK = new Object();
    private static TaskExecutors sInstance;
    private final Executor db;

    private TaskExecutors(Executor db) {
        this.db = db;
    }

    public static TaskExecutors getInstance() {
        if(sInstance == null) {
            synchronized (LOCK) {
                sInstance = new TaskExecutors(Executors.newSingleThreadExecutor());
            }
        }
        return sInstance;
    }

    public Executor db() {
        return db;
    }
}
