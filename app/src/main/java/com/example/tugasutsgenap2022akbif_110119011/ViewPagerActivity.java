package com.example.tugasutsgenap2022akbif_110119011;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ViewPagerActivity extends AppCompatActivity {
    Button button;
    ViewPager viewPager;
    int[] layouts;
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        viewPager = findViewById(R.id.pager);

        layouts = new int[] {
                R.layout.page1,
                R.layout.page2,
                R.layout.page3
        };

        adapter = new Adapter(this, layouts);
        viewPager.setAdapter(adapter);

    }

    public void Alihkan(View view) {
        startActivity(new Intent(ViewPagerActivity.this,MainActivity.class));
        finish();
    }

}