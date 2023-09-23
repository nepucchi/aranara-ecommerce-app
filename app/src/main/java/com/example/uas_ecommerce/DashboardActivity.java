package com.example.uas_ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashboardActivity extends AppCompatActivity {

    HomeFragment homeFragment = new HomeFragment();
    HistoryFragment historyFragment = new HistoryFragment();
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.idBotNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.containerID, homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Dashboard:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerID, homeFragment).commit();
                        return true;
                    case R.id.History:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containerID, historyFragment).commit();
                        return true;

                }
                return false;
            }
        });

    }
}