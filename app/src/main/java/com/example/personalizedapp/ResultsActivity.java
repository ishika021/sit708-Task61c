package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    TextView tvCongratulations, tvScore;
    Button btnGoHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        tvCongratulations = findViewById(R.id.tvCongratulations);
        tvScore = findViewById(R.id.tvScore);
        btnGoHome = findViewById(R.id.btnGoHome);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        tvCongratulations.setText("Congratulations!");
        tvScore.setText("You scored: " + score + " points!");

        btnGoHome.setOnClickListener(v -> {
            Intent backIntent = new Intent(ResultsActivity.this, HomeActivity.class);
            startActivity(backIntent);
            finish();
        });
    }
}
