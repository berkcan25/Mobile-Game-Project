package com.example.myapplication.FlappyBirdCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class GameScreenFlappybird extends AppCompatActivity {
    private ImageView mImageView;
    private TextView displayUserName;
    private Button cButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen_flappybird);
        AppConstants.initialization(this.getApplicationContext());

        cButton = (Button) findViewById(R.id.buttonStart);
        cButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });
    }

    public void startGame(){
        Intent intent = new Intent(GameScreenFlappybird.this, GameActivity.class);
        startActivity(intent);
        finish();
    }
}
