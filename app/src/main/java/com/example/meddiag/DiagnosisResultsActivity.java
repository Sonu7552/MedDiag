package com.example.meddiag;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DiagnosisResultsActivity extends AppCompatActivity {

    private TextView diagnosisTextView;  // Corrected the variable name to match the XML
    private Button viewMoreButton;  // You'll need to add this button to your XML layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis_results);

        diagnosisTextView = findViewById(R.id.diagnosisTextView);  // Corrected the ID
        viewMoreButton = findViewById(R.id.view_more_button);  // You'll need to add this button in XML

        // Sample result (replace with actual diagnosis data)
        diagnosisTextView.setText("Result: Pneumonia detected.");

        viewMoreButton.setOnClickListener(view -> {
            // Logic to view more information (to be implemented)
        });
    }
}
