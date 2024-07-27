package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlarmMainActivity extends AppCompatActivity {

    static final int ALARM_REQ_CODE = 100;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                int time =Integer.parseInt(((EditText)(findViewById(R.id.editTime))).getText().toString());
                long triggerTime = System.currentTimeMillis()+(time*3600000);

                Intent iBroadcast = new Intent(AlarmMainActivity.this, MyReceiver.class);

                PendingIntent pi =PendingIntent.getBroadcast(AlarmMainActivity.this,ALARM_REQ_CODE,iBroadcast,PendingIntent.FLAG_UPDATE_CURRENT);


                alarmManager.set(AlarmManager.RTC_WAKEUP, triggerTime, pi);

                Toast.makeText(getApplicationContext(), "YOUR REMAINDER IS ON", Toast.LENGTH_SHORT).show();
            }
        });
    }
}