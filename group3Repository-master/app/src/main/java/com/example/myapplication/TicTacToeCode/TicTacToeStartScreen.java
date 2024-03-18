package com.example.myapplication.TicTacToeCode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.GameStart;
import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

public class TicTacToeStartScreen extends AppCompatActivity implements GameStart {
    private Button exitButton;
    private ImageButton configButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tictactoe);
        exitButton = (Button) findViewById(R.id.button);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
            }
        });

        configButton = (ImageButton) findViewById(R.id.imageButton2);
        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitButtonClick();
            }
        });
    }

    public void playButtonClick() {
        Intent intent = new Intent(this, TicTacToeConfigurationScreen.class);
        startActivity(intent);
        // add another action for the exit button
    }

    public void exitButtonClick() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }

}