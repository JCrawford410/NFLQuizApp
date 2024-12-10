package org.forestpark.nflquizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button yesButton, noButton;
    private int currentQuestion = 0;
    private int score = 0;

    private String[] questions = {
            "Can a team attempt a two-point conversion after every touchdown?",
            "Are all penalties in American football worth 10 yards?",
            "Can a defensive player score points for their team?",
            "Is a fumble recoverable by either team?",
            "Are college football overtime rules different from NFL overtime rules?"
    };

    private boolean[] answers = { true, false, true, true, false };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.questionTextView);
        yesButton = findViewById(R.id.yesButton);
        noButton = findViewById(R.id.noButton);

        updateQuestion();

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }

    private void updateQuestion() {
        if (currentQuestion < questions.length) {
            questionTextView.setText(questions[currentQuestion]);
        } else {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    private void checkAnswer(boolean userAnswer) {
        if (userAnswer == answers[currentQuestion]) {
            score++;
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        }

        currentQuestion++;
        updateQuestion();
    }
}

