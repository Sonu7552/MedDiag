package com.example.meddiag;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import androidx.appcompat.app.ActionBarDrawerToggle;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Button diagnosisButton, resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        diagnosisButton = findViewById(R.id.diagnosisButton);
        resultButton = findViewById(R.id.resultButton);  // New button for Result Activity

        // Set up the toolbar as an action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set up ActionBarDrawerToggle for the drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Handle diagnosis button click
        diagnosisButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ImageCaptureActivity.class);
            startActivity(intent);
        });

        // Handle result button click
        resultButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DiagnosisResultsActivity.class);
            startActivity(intent);
        });

        // Handle navigation item clicks
        navigationView.setNavigationItemSelectedListener(this::onNavigationItemSelected);
    }

    // Handle item selection from the navigation drawer
    private boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_logout) {
            // Log out from Firebase
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        } else if (id == R.id.nav_profile) {
            // Navigate to UserProfileActivity
            Intent intent = new Intent(MainActivity.this, UserProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_diagnosis_history) {
            // Navigate to DiagnosisHistoryActivity
            Intent intent = new Intent(MainActivity.this, DiagnosisHistoryActivity.class);
            startActivity(intent);
        }
        // Close the drawer when an item is selected
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(navigationView)) {
            drawerLayout.closeDrawer(navigationView);
        } else {
            super.onBackPressed();
        }
    }
}
