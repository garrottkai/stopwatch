package com.kaigarrott.stopwatch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class StopwatchService extends Service {
    public StopwatchService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
