package com.example.meddiag;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DiagnosisHistoryActivity extends AppCompatActivity {

    private ListView diagnosisHistoryListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis_history);

        diagnosisHistoryListView = findViewById(R.id.diagnosisHistoryListView);

        // Mocked diagnosis history data
        ArrayList<String> diagnosisHistory = new ArrayList<>();
        diagnosisHistory.add("Date: 2024-11-01\nDiagnosis: Mild Flu");
        diagnosisHistory.add("Date: 2024-10-15\nDiagnosis: Normal ECG");
        diagnosisHistory.add("Date: 2024-09-28\nDiagnosis: Possible Pneumonia");
        diagnosisHistory.add("Date: 2024-08-30\nDiagnosis: No Issues Detected");

        // Adapter to display history in ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                diagnosisHistory
        );

        diagnosisHistoryListView.setAdapter(adapter);
    }
}
