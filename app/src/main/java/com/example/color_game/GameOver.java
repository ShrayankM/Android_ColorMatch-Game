package com.example.color_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    TextView score;
    int finalScore;
    Button retry,exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        score = findViewById(R.id.final_score);
        retry = findViewById(R.id.button_retry);
        exit  = findViewById(R.id.button_exit);
        Intent intent = getIntent();
        finalScore = intent.getIntExtra("score",0);
        score.setText(String.valueOf(finalScore));
        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GameOver.this.startActivity(new Intent(GameOver.this,GameActivity.class));
                GameOver.this.finish();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
