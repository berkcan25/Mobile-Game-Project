package com.example.myapplication.TicTacToeCode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

public class TicTacToeGameScreen extends AppCompatActivity {

    public ImageView image1;
    public ImageView image2;
    private TextView text1;
    private TextView text2;
    private TicTacToeBoard ticTacToeBoard;
    private Button topButton;
    private Button bottomButton;
    private int counter1 = 0;
    private int counter2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game_screen);
        image1 = findViewById(R.id.imageView5);
        image2 = findViewById(R.id.imageView6);
        text1 = findViewById(R.id.textView5);
        text2 = findViewById(R.id.textView6);
        Intent intent = getIntent();
        String[] playerNames = intent.getStringArrayExtra("PLAYER_NAMES");
        String inputName = playerNames[0];
        int inputImage = getIntent().getIntExtra(TicTacToeConfigurationScreen.key2, 1);
        text1.setText(inputName);
        image1.setImageResource(inputImage);
        String inputName2 = playerNames[1];
        int inputImage2 = getIntent().getIntExtra(TicTacToeConfigurationScreen.key3, 1);
        text2.setText(inputName2);
        image2.setImageResource(inputImage2);
        ticTacToeBoard = findViewById(R.id.ticTacToeBoard7);
        Button playAgainBTN = findViewById(R.id.button8);
        Button homeButton = findViewById(R.id.button7);

        topButton = findViewById(R.id.topButton);
        bottomButton = findViewById(R.id.bottomButton);
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter1++;
                topButton.setText("score: " + String.valueOf(counter1));
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                bottomButton.setText("score: " + String.valueOf(counter2));
            }
        });

        TextView playerTurn = findViewById(R.id.textView7);


        ticTacToeBoard.setUpGame(playAgainBTN, homeButton, playerTurn, playerNames);
        if(playerNames != null){
            playerTurn.setText((playerNames[0] + "'s Turn"));
        }

        playAgainBTN.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);
    }

    public void playAgainButtonClick(View view) {
        ticTacToeBoard.resetGames();

        ticTacToeBoard.invalidate();
    }

    public void homeButtonClick(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}
