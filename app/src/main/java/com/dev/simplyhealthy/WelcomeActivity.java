package com.dev.simplyhealthy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {
    Button btn;
    TextView noInternet;
    ImageView noWifi;
    Context context;
    TextView textView;
    //use Array
    String text[]={"  SIMPLY HEALTHY... \uD83D\uDE07             _","Easier to make healthy choice_","Linked to health_","Health in your pocket_"};
    //count for i
    int i=0;
    //count for j
    int j=0;






    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        textView = findViewById(R.id.newtext);

        initialize(text[j]);



        noInternet = findViewById(R.id.no_internet);
        noWifi = findViewById(R.id.no_wifi);

        btn = findViewById(R.id.Getstart);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(WelcomeActivity.this, loginActivity.class));
            }
        });
        if(!isConnected())
        {
            noWifi.setVisibility(View.VISIBLE);
            noInternet.setVisibility(View.VISIBLE);
            Toast.makeText(getApplicationContext(), "NO INTERNET CONECTION", Toast.LENGTH_SHORT).show();


        }
        if(isConnected())
        {
            Toast.makeText(getApplicationContext(), "WELCOME", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), "YOUR ONLINE", Toast.LENGTH_SHORT).show();

        }




    }

    private void initialize(String passed_text)
    {
        if (i<passed_text.length()){
            String fetch_text=passed_text.substring(0,i);
            textView.setText(fetch_text);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    i++;
                    initialize(passed_text);
                }
            },140);
        }
        else {
            j++;
            if(j==text.length){
                i=0;
                j=0;
                initialize(text[j]);
            }
            else{
                i=0;
                initialize(text[j]);

            }
        }
    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

    }

}