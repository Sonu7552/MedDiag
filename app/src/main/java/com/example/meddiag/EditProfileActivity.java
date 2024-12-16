package com.example.meddiag;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {

    private EditText editTextName, editTextEmail;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        // Find the views
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        saveButton = findViewById(R.id.saveButton);

        // Pre-fill the fields with current data (optional)
        SharedPreferences sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);
        String currentName = sharedPreferences.getString("name", "Joe Doe");
        String currentEmail = sharedPreferences.getString("email", "joe.doe@example.com");

        editTextName.setText(currentName);
        editTextEmail.setText(currentEmail);

        saveButton.setOnClickListener(v -> {
            String updatedName = editTextName.getText().toString().trim();
            String updatedEmail = editTextEmail.getText().toString().trim();

            if (updatedName.isEmpty() || updatedEmail.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            } else {
                // Save the updated data to SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", updatedName);
                editor.putString("email", updatedEmail);
                editor.apply();

                // Show success message
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show();

                // Navigate back to UserProfileActivity
                Intent intent = new Intent(EditProfileActivity.this, UserProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
