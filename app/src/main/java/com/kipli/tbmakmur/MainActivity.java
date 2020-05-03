package com.kipli.tbmakmur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kipli.tbmakmur.fragment.BasketFragment;
import com.kipli.tbmakmur.fragment.HomeFragment;
import com.kipli.tbmakmur.fragment.ProfileFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, new HomeFragment()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragment();
                break;
                case R.id.basket:
                    selectedFragment = new BasketFragment();
                break;
                case R.id.profile:
                    selectedFragment = new ProfileFragment();
                break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,selectedFragment).commit();
            return true;
        }
    };

}
