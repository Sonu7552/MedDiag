package com.example.meddiag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class UserProfileActivity extends AppCompatActivity {

    private TextView nameTextView, emailTextView, medicalHistoryTextView;
    private Button editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        // Find the views
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);
        medicalHistoryTextView = findViewById(R.id.medicalHistoryTextView);
        editProfileButton = findViewById(R.id.editProfileButton);

        // Load the user profile data from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "Joe Doe");
        String email = sharedPreferences.getString("email", "joe.doe@example.com");
        String medicalHistory = sharedPreferences.getString("medicalHistory", "No medical history");

        // Display the user data
        nameTextView.setText("Name: " + name);
        emailTextView.setText("Email: " + email);
        medicalHistoryTextView.setText("Medical History: " + medicalHistory);

        // Set up the button to navigate to EditProfileActivity
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(UserProfileActivity.this, EditProfileActivity.class);
            startActivity(intent);
        });
    }
}
