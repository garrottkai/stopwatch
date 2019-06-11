package com.kaigarrott.stopwatch;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private StopwatchThread mThread;
    private TextView mOutputView;
    private boolean mRunning = false;
    private FloatingActionButton mButton;

    private RecyclerView mTimesView;
    private RecyclerView.Adapter mTimesAdapter;
    private RecyclerView.LayoutManager mTimesLayoutManager;

    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.fab);
        mOutputView = findViewById(R.id.output);
        mTimesView = findViewById(R.id.times_view);
        mTimesView.setHasFixedSize(true);
        mTimesLayoutManager = new LinearLayoutManager(this);
        mTimesView.setLayoutManager(mTimesLayoutManager);
        String[] testData = new String[]{"01:02:03.04", "02:02:03.04", "03:02:03.04", "04:02:03.04", "05:02:03.04", "06:02:03.04", "07:02:03.04", "08:02:03.04"};
        mTimesAdapter = new TimesAdapter(testData);
        mTimesView.setAdapter(mTimesAdapter);
    }

    private void start() {
        mRunning = true;
        mButton.setImageResource(R.drawable.ic_stop);
        mThread = new StopwatchThread();
        mThread.start();
    }

    private void stop() {
        mRunning = false;
        mButton.setImageResource(R.drawable.ic_start);
        if(mThread != null) mThread.interrupt();
        mThread = null;
    }

    public void toggle(View v) {
        if(mRunning) {
            stop();
        } else {
            start();
        }
    }

    private class StopwatchThread extends Thread {
        @Override
        public void run() {

            super.run();
            long begin = new Date().getTime();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mOutputView.setText(getString(R.string.default_time_value));
                }
            });

            try {
                while(!this.isInterrupted()) {

                    long diff = new Date().getTime() - begin;
                    int h = (int) Math.floor(diff / 3600000);
                    int m = (int) Math.floor((diff % 3600000) / 60000);
                    int s = (int) Math.floor((diff % 60000) / 1000);
                    int cs = (int) Math.floor((diff % 1000) / 10);

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

                }
            } catch (InterruptedException e) {
            }
        }
    }
}
