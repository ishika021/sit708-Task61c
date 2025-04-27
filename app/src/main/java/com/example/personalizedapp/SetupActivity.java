package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class SetupActivity extends AppCompatActivity {

    EditText edtName, edtAge, edtGrade;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        edtName = findViewById(R.id.edtName);
        edtAge = findViewById(R.id.edtAge);
        edtGrade = findViewById(R.id.edtGrade);
        btnNext = findViewById(R.id.btnNextSetup);

        btnNext.setOnClickListener(v -> {
            startActivity(new Intent(SetupActivity.this, InterestsActivity.class));
        });
    }
}
