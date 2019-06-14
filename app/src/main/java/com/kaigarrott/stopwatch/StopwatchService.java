package com.kaigarrott.stopwatch;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class StopwatchService extends Service {

    private static final String CHANNEL_ID = "stopwatch_channel";
    private Notification notification;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
       // return super.onStartCommand(intent, flags, startId);
        if(notification == null) notification = setupNotification();
        startForeground(123, notification);
        return Service.START_STICKY;
    }

    private Notification setupNotification() {

        Notification.Builder builder;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Stopwatch",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Live stopwatch times");
            manager.createNotificationChannel(channel);
            builder = new Notification.Builder(getApplicationContext(), CHANNEL_ID);
        } else {
            builder = new Notification.Builder(getApplicationContext());
        }
        return builder.setContentTitle("Stopwatch")
                .setOngoing(true)
                .build();
    }
}
