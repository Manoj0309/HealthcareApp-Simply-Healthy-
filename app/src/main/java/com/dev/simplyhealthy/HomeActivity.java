package com.dev.simplyhealthy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;



public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString( "username", "").toString();
        Toast.makeText(getApplicationContext(), "Welcome "+username, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "HOME PAGE", Toast.LENGTH_LONG).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.clear();
                startActivity(new Intent( HomeActivity.this,loginActivity.class));
            }
        });

        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,FindDoctorActivity.class));
            }
        });

        CardView labTest = findViewById(R.id.cardLabtest);
        labTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,LabTestActivity.class));
            }
        });
        CardView StopWatch = findViewById(R.id.cardBuyMedicine);
        StopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,WorkoutActivity.class));
            }
        });
        CardView orderDetails = findViewById(R.id.cardOrderDetails);
        orderDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,MAlarmActivity.class));
            }
        });

        CardView health = findViewById(R.id.cardHealthDoctor);
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( HomeActivity.this,HealthArticleActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private static final int MENU_HOME = R.id.nav_home;
    private static final int MENU_BUS = R.id.nav_bus;
    private static final int MENU_SHARE = R.id.nav_share;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if (itemId == MENU_HOME) {
            // Handle the Home menu item
        } else if (itemId == MENU_BUS) {
            Intent busIntent = new Intent(HomeActivity.this, LabTestActivity.class);
            startActivity(busIntent);
        } else if (itemId == MENU_SHARE) {
            Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
        } else {
            throw new IllegalStateException("Unexpected value: " + itemId);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
  }

}