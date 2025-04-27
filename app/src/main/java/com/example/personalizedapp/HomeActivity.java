package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button btnTasks, btnResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnTasks = findViewById(R.id.btnTasks);
        btnResults = findViewById(R.id.btnResults);

        btnTasks.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, TaskActivity.class))
        );

        btnResults.setOnClickListener(v ->
                startActivity(new Intent(HomeActivity.this, ResultsActivity.class))
        );
    }
}
