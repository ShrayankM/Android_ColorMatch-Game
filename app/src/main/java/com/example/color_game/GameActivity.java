package com.example.color_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    TextView color_name;
    TextView score;
    Button left_color,right_color;
    Handler h = new Handler();
    Random r = new Random();
    int text_color = 0 , text_name = 0;
    public int game_score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        color_name = findViewById(R.id.color_display);
        left_color = findViewById(R.id.left_button);
        right_color = findViewById(R.id.right_button);
        score = findViewById(R.id.final_score);
        game_score = 0;
        startGame();
    }
    public void startGame(){
            final String[] colorNames = getResources().getStringArray(R.array.colorsNames);
            TypedArray ta = getResources().obtainTypedArray(R.array.colors);
            text_color = r.nextInt(14);
            text_name  = r.nextInt(14);
            while(text_color == text_name){
                text_color = r.nextInt(14);
                text_name  = r.nextInt(14);
            }
            int colorToUse = ta.getColor(text_color, 0);
            color_name.setTextColor(colorToUse);
            color_name.setText(colorNames[text_name]);

            int button_random = r.nextInt(2);
            if(button_random == 0){
                left_color.setText(colorNames[text_color]);
                right_color.setText(colorNames[text_name]);
            }
            else{
                left_color.setText(colorNames[text_name]);
                right_color.setText(colorNames[text_color]);
            }
            left_color.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(left_color.getText() == colorNames[text_color]) {
                        game_score++;
                        score.setText(String.valueOf(game_score));
                    }
                    else{
                        Intent intent = new Intent(GameActivity.this,GameOver.class);
                        intent.putExtra("score",game_score);
                        startActivity(intent);
                        GameActivity.this.finish();
                    }
                }
            });

            right_color.setOnClickListener(new View.OnClickListener() {
                    @Override
                public void onClick(View v) {
                    if(right_color.getText() == colorNames[text_color]) {
                        game_score++;
                        score.setText(String.valueOf(game_score));
                    }
                    else{
                        Intent intent = new Intent(GameActivity.this,GameOver.class);
                        intent.putExtra("score",game_score);
                        startActivity(intent);
                        GameActivity.this.finish();
                    }
                }
            });
            System.out.println(game_score);
            timer(3000);
    }

    public void timer(int milli) {
        Runnable run = new Runnable() {
            public void run() {
                    GameActivity.this.startGame();
            }
        };
         this.h.postDelayed(run, (long) milli);
    }
}
