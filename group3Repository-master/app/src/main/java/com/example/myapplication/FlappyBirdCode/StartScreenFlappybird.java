package com.example.myapplication.FlappyBirdCode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.myapplication.GameStart;
import com.example.myapplication.MainScreen;
import com.example.myapplication.R;

public class StartScreenFlappybird extends AppCompatActivity implements GameStart {
    private Button exitButtonFlappy;
    private ImageButton configButtonFlappy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flappybird);
        exitButtonFlappy = (Button) findViewById(R.id.button);
        exitButtonFlappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playButtonClick();
            }
        });

        configButtonFlappy = (ImageButton) findViewById(R.id.imageButton2);
        configButtonFlappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitButtonClick();
            }
        });
    }

    public void playButtonClick() {
        Intent intent = new Intent(this, InitialConfigurationScreenFlappybird.class);
        startActivity(intent);
    }

    public void exitButtonClick() {
        Intent intent = new Intent(this, MainScreen.class);
        startActivity(intent);
    }
}