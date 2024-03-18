package com.example.myapplication.FlappyBirdCode;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class GameActivity extends Activity {
    FlappyBirdGameView  flappyBirdGameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppConstants.gameActivityContext = this;
        flappyBirdGameView = new FlappyBirdGameView(this);
        setContentView(flappyBirdGameView);
    }
}
