package com.example.myapplication.SudokuCode;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.GameStart;
import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

public class StartScreenSudoku extends AppCompatActivity implements GameStart {
    private ImageButton exitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sudoku);
        Button gameScreenButton = (Button) findViewById(R.id.GameScreenbutton);
        gameScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
            }
        });

        exitButton = (ImageButton) findViewById(R.id.imageButton2);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitButtonClick();
            }
        });
    }

    @Override
    public void playButtonClick() {
        Intent intent = new Intent(this, InitialConfigurationScreenSudoku.class);
        startActivity(intent);
    }

    @Override
    public void exitButtonClick() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}