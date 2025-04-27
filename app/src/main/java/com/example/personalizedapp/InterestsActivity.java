package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class InterestsActivity extends AppCompatActivity {

    Button btnSubmit;
    CheckBox cbAlgorithms, cbDataStructures, cbWebDev, cbTesting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        btnSubmit = findViewById(R.id.btnNextInterest);
        cbAlgorithms = findViewById(R.id.cbAlgorithms);
        cbDataStructures = findViewById(R.id.cbDataStructures);
        cbWebDev = findViewById(R.id.cbWebDevelopment);
        cbTesting = findViewById(R.id.cbTesting);

        btnSubmit.setOnClickListener(v -> {
            List<String> selectedInterests = new ArrayList<>();

            if (cbAlgorithms.isChecked()) selectedInterests.add("Algorithms");
            if (cbDataStructures.isChecked()) selectedInterests.add("Data Structures");
            if (cbWebDev.isChecked()) selectedInterests.add("Web Development");
            if (cbTesting.isChecked()) selectedInterests.add("Testing");

            if (selectedInterests.isEmpty()) {
                Toast.makeText(this, "Please select at least one interest", Toast.LENGTH_SHORT).show();
            } else {

                Intent intent = new Intent(InterestsActivity.this, TaskActivity.class);
                intent.putExtra("interest", selectedInterests.get(0));
                startActivity(intent);
            }
        });
    }
}
