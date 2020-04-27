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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.view_mode, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.list_mode:
            break;
            case R.id.list_cardview:
            break;
            case R.id.list_grid:
            break;
        }
    }
}
