package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InterestsActivity extends AppCompatActivity {

    CheckBox cbAlgorithms, cbDataStructures, cbWebDevelopment, cbTesting;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        cbAlgorithms = findViewById(R.id.cbAlgorithms);
        cbDataStructures = findViewById(R.id.cbDataStructures);
        cbWebDevelopment = findViewById(R.id.cbWebDevelopment);
        cbTesting = findViewById(R.id.cbTesting);
        btnNext = findViewById(R.id.btnNextInterest);

        btnNext.setOnClickListener(v -> {
            String selectedInterest = "";

            if(cbAlgorithms.isChecked()) selectedInterest = "Algorithms";
            else if(cbDataStructures.isChecked()) selectedInterest = "Data Structures";
            else if(cbWebDevelopment.isChecked()) selectedInterest = "Web Development";
            else if(cbTesting.isChecked()) selectedInterest = "Testing";

            if(selectedInterest.isEmpty()) {
                Toast.makeText(this, "Please select at least one interest!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(InterestsActivity.this, TaskActivity.class);
                intent.putExtra("interest", selectedInterest);
                startActivity(intent);
                finish();
            }
        });
    }
}
