package com.example.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.collegeapp.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this , R.id.frame_layout);

        NavigationUI.setupWithNavController(bottomNavigationView , navController);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.start , R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }

        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.navigation_developer:
                Toast.makeText(this, "navigation_developer", Toast.LENGTH_SHORT).show();
            case R.id.navigation_video:
                Toast.makeText(this, "navigation_video", Toast.LENGTH_SHORT).show();
            case R.id.navigation_rate:
                Toast.makeText(this, "navigation_rate", Toast.LENGTH_SHORT).show();
            case R.id.navigation_ebook:
                startActivity(new Intent(this , EbookActivity.class));
            case R.id.navigation_theme:
                Toast.makeText(this, "navigation_theme", Toast.LENGTH_SHORT).show();
            case R.id.navigation_website:
                Toast.makeText(this, "navigation_website", Toast.LENGTH_SHORT).show();
            case R.id.navigation_share:
                Toast.makeText(this, "navigation_share", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}