package com.kaigarrott.stopwatch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static String format(long value) {
        long h = TimeUnit.MILLISECONDS.toHours(value);
        long m = TimeUnit.MILLISECONDS.toMinutes(value - TimeUnit.MILLISECONDS.toMillis(h));
        long s = TimeUnit.MILLISECONDS.toSeconds(value - TimeUnit.MILLISECONDS.toMillis(h) - TimeUnit.MILLISECONDS.toMillis(m));
        long cs = (long) Math.floor(TimeUnit.MILLISECONDS.toMillis(value - TimeUnit.MILLISECONDS.toMillis(h) - TimeUnit.MILLISECONDS.toMillis(m) - TimeUnit.MILLISECONDS.toMillis(s)) / 10);
        return String.format("%02d:%02d:%02d.%02d", h, m, s, cs);
//        Date date = new Date(value);
//        return new SimpleDateFormat("HH:mm:ss.SS").format(date);
    }
}
