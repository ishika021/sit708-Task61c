package com.example.personalizedapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskActivity extends AppCompatActivity {

    LinearLayout taskContainer;
    Button btnSubmit;
    String selectedInterest = "Algorithms"; // default
    String[] questions;
    int[] correctAnswers; // store correct answers
    RadioGroup[] allRadioGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        taskContainer = findViewById(R.id.taskContainer);
        btnSubmit = findViewById(R.id.btnSubmitTask);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("interest")) {
            selectedInterest = intent.getStringExtra("interest");
        }

        loadQuestions(selectedInterest);

        btnSubmit.setOnClickListener(v -> {
            boolean allAnswered = true;

            for (RadioGroup rg : allRadioGroups) {
                if (rg.getCheckedRadioButtonId() == -1) {
                    allAnswered = false;
                    break;
                }
            }

            if (allAnswered) {
                int score = calculateScore();
                Intent resultIntent = new Intent(TaskActivity.this, ResultsActivity.class);
                resultIntent.putExtra("score", score);
                resultIntent.putExtra("total", questions.length);
                startActivity(resultIntent);
                finish();
            } else {
                Toast.makeText(this, "Please answer all questions", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadQuestions(String interest) {
        switch (interest) {
            case "Algorithms":
                questions = getResources().getStringArray(R.array.algorithms_questions);
                correctAnswers = new int[]{0, 1, 2};
                break;
            case "Data Structures":
                questions = getResources().getStringArray(R.array.datastructures_questions);
                correctAnswers = new int[]{0, 1, 2};
                break;
            case "Web Development":
                questions = getResources().getStringArray(R.array.webdevelopment_questions);
                correctAnswers = new int[]{0, 1, 2};
                break;
            case "Testing":
                questions = getResources().getStringArray(R.array.testing_questions);
                correctAnswers = new int[]{0, 1, 2};
                break;
        }

        allRadioGroups = new RadioGroup[questions.length];

        for (int i = 0; i < questions.length; i++) {
            TextView textView = new TextView(this);
            textView.setText((i + 1) + ". " + questions[i]);
            textView.setTextSize(18);
            textView.setPadding(0, 24, 0, 24);
            taskContainer.addView(textView);

            RadioGroup optionsGroup = new RadioGroup(this);
            optionsGroup.setOrientation(RadioGroup.VERTICAL);

            RadioButton option1 = new RadioButton(this);
            option1.setText("Option 1"); // assume first is correct
            RadioButton option2 = new RadioButton(this);
            option2.setText("Option 2");
            RadioButton option3 = new RadioButton(this);
            option3.setText("Option 3");

            optionsGroup.addView(option1);
            optionsGroup.addView(option2);
            optionsGroup.addView(option3);

            taskContainer.addView(optionsGroup);
            allRadioGroups[i] = optionsGroup;
        }
    }

    private int calculateScore() {
        int score = 0;
        for (int i = 0; i < allRadioGroups.length; i++) {
            int selectedId = allRadioGroups[i].getCheckedRadioButtonId();
            RadioButton selected = findViewById(selectedId);
            int selectedIndex = allRadioGroups[i].indexOfChild(selected);
            if (selectedIndex == correctAnswers[i]) {
                score++;
            }
        }
        return score;
    }
}
