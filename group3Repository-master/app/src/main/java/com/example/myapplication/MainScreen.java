package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.FlappyBirdCode.StartScreenFlappybird;
import com.example.myapplication.SudokuCode.StartScreenSudoku;
import com.example.myapplication.TicTacToeCode.TicTacToeStartScreen;

public class MainScreen extends AppCompatActivity {
    private Button flappyBirdbutton;
    private Button sudokuButton;
    private Button tictactoeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flappyBirdbutton = (Button) findViewById(R.id.Flappybirdbuton);
        flappyBirdbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreenFlappybird();
            }
        });

        sudokuButton = (Button) findViewById(R.id.Sudokubutton);
        sudokuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStartScreenSudoku();
            }
        });
        
            
        tictactoeButton = (Button) findViewById(R.id.Tictactoebutton);

        tictactoeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { openTicTacToeStartScreen(); }
        });
    }

    public void openStartScreenFlappybird() {
        Intent intent = new Intent(this, StartScreenFlappybird.class);
        startActivity(intent);
    }

    public void openStartScreenSudoku() {
        Intent intent = new Intent(this, StartScreenSudoku.class);
        startActivity(intent);
    }

    public void openTicTacToeStartScreen() {
        Intent intent = new Intent(this, TicTacToeStartScreen.class);
        startActivity(intent);
    }
}

