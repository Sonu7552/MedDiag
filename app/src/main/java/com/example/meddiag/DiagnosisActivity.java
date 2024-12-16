package com.example.meddiag;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DiagnosisActivity extends AppCompatActivity {

    private ImageView diagnosisImageView;
    private TextView diagnosisResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        diagnosisImageView = findViewById(R.id.diagnosisImageView);
        diagnosisResultTextView = findViewById(R.id.diagnosisResultTextView);

        Bitmap imageBitmap = getIntent().getParcelableExtra("imageBitmap");
        if (imageBitmap != null) {
            diagnosisImageView.setImageBitmap(imageBitmap);
        }

        // Placeholder result for future integration
        diagnosisResultTextView.setText("Diagnosis Result: [Mock Result]");
    }
}
