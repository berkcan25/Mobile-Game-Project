package com.example.myapplication.FlappyBirdCode;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.GameStart;
import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

// Main idea of this class is to switch to this screen and class once the bird touches the tube
public class GameOverScreen extends AppCompatActivity {

    private Button playAgainButton;
    private TextView gameOverText;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_screen);
        int score = getIntent().getExtras().getInt("score");

        playAgainButton = (Button) findViewById(R.id.button5);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAgain(v);
            }
        });

        gameOverText = (TextView) findViewById(R.id.textView8);
        scoreText = (TextView) findViewById(R.id.textView9);
        scoreText.setText("Score: " + score); // Gotta display the score here
    }

    public void playAgain(View view) {
        Intent intent = new Intent(GameOverScreen.this, GameScreenFlappybird.class);
        startActivity(intent);
        finish();
    }

    public void homeButtonClick(View view) {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
        finish();
    }

}