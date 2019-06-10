package com.kaigarrott.stopwatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private StopwatchThread mThread;
    private TextView mOutputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mThread = new StopwatchThread();
        mOutputView = findViewById(R.id.output);
    }

    private void start() {
        mThread.start();
    }

    private void stop() {
        mThread.interrupt();
    }

    private class StopwatchThread extends Thread {
        @Override
        public void run() {

            super.run();
            long now = new Date().getTime();
            mOutputView.setText("00:00:00.00");

            while(!interrupted()) {
                try {
                    long diff = new Date().getTime() - now;
                    double h = Math.floor(diff / 3600000);
                    double m = Math.floor((diff % 3600000) / 60000);
                    double s = Math.floor((m % 60000) / 1000);
                    double cs = Math.floor((s % 1000) / 10);

                    String outH = "";
                    String outM = "";
                    String outS = "";
                    String outCs = "";

                    if (h < 10) outH += "0";
                    if (m < 10) outM += "0";
                    if (s < 10) outS += "0";
                    if (cs < 10) outCs += "0";

                    outH += String.valueOf(h);
                    outM += String.valueOf(m);
                    outS += String.valueOf(s);
                    outCs += String.valueOf(cs);

                    final String out = outH + ":" + outM + ":" + outS + "." + outCs;

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mOutputView.setText(out);
                        }
                    });

                    Thread.sleep(10);
                } catch (InterruptedException e) {

                }
            }
        }
    }
}
