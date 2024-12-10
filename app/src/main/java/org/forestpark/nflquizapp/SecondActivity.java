package org.forestpark.nflquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView scoreTextView;
    private Button retryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        scoreTextView = findViewById(R.id.scoreTextView);
        retryButton = findViewById(R.id.retryButton);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);
        scoreTextView.setText("Your score: " + score);

        retryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retryIntent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(retryIntent);
                finish();
            }
        });
    }
}

