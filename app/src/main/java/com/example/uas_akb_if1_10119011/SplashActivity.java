package com.example.uas_akb_if1_10119011;
//Identitas
//Nama  : Reihan Wiyanda
//Kelas : IF-1
//Nim   : 10119011
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

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
                startActivity(new Intent(getApplicationContext(), ViewPagerActivity.class));
                finish();
            }
        }, 4000);
    }
}