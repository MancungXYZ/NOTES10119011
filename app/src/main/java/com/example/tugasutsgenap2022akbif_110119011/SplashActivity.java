package com.example.tugasutsgenap2022akbif_110119011;
//Identitas
//Nama  : Reihan Wiyanda
//Kelas : IF-1
//Nim   : 10119011
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    LauncherManager launcherManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        launcherManager = new LauncherManager(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (launcherManager.isFirstTime()) {
                    launcherManager.setFirstLunch(false);
                    startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(getApplicationContext(), NavigationActivity.class));
                    finish();
                }
            }
        }, 4000);
    }
}