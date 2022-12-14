package com.example.uas_akb_if1_10119011;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
//Identitas
//Nama  : Reihan Wiyanda
//Nim   : 10119011
//Kelas : IF-1
public class NavigationActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Profile profileFragment = new Profile();
    Keluar keluarFragment = new Keluar();
    NoteFragment noteFragment = new NoteFragment();
    AboutFragment aboutFragment = new AboutFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, aboutFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.aboutFragment:
                        selectedFragment = aboutFragment;
                        break;
                    case R.id.noteFragment:
                        selectedFragment = noteFragment;
                        break;
                    case R.id.profileFragment:
                        selectedFragment = profileFragment;
                        break;
                    case R.id.keluarFragment:
                        selectedFragment = keluarFragment;
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return true;
            }
        });
    }
}