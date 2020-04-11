package com.example.color_game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void start_game(View view) {
        MainActivity.this.startActivity(new Intent(MainActivity.this,GameActivity.class));
        MainActivity.this.finish();
    }
}
