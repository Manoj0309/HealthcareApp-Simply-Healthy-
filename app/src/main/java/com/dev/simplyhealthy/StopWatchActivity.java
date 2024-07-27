package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;

public class StopWatchActivity extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseoffset;
    private boolean running;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        chronometer = findViewById(R.id.chronometer);

    }

    public void startChronometer(View v) {
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View v) {
        if(running){
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false ;
        }

    }

    public void resetChronometer(View v) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;

    }
}