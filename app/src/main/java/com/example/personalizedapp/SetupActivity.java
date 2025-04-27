package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    EditText name, age, grade;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        name = findViewById(R.id.edtName);
        age = findViewById(R.id.edtAge);
        grade = findViewById(R.id.edtGrade);
        next = findViewById(R.id.btnNextSetup);

        next.setOnClickListener(v -> {
            // Just go to Interests page
            startActivity(new Intent(SetupActivity.this, InterestsActivity.class));
            finish();
        });
    }
}
