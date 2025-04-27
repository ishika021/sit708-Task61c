package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView tvCongratulations, tvScore;
    Button btnGoHome, btnRetake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvCongratulations = findViewById(R.id.tvCongratulations);
        tvScore = findViewById(R.id.tvScore);
        btnGoHome = findViewById(R.id.btnGoHome);
        btnRetake = findViewById(R.id.btnRetake);

        Intent receivedIntent = getIntent();
        int score = receivedIntent.getIntExtra("score", 0);
        int total = receivedIntent.getIntExtra("total", 0);

        tvCongratulations.setText("Well Done!");
        tvScore.setText("You scored " + score + " out of " + total);

        btnGoHome.setOnClickListener(v -> {
            startActivity(new Intent(ResultsActivity.this, HomeActivity.class));
            finish();
        });

        btnRetake.setOnClickListener(v -> {
            startActivity(new Intent(ResultsActivity.this, InterestsActivity.class));
            finish();
        });
    }
}
