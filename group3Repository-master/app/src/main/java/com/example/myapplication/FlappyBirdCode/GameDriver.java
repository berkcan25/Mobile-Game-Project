package com.example.myapplication.FlappyBirdCode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class GameDriver {
    BackgroundImage backgroundImage;
    Bird bird;
    //gameState 0 = Not started
    //gameState 1 = Playing
    //gameState 2 = GameOver
    static int gameState;
    ArrayList<Tube> tubes;
    Random random;
    int score; // Stores the score
    int lives;
    int scoringTube; // Keeps track of the scoring tube (the tube in front of the bird)
    Paint scorePaint; // Shows score

    public GameDriver() {
        backgroundImage = new BackgroundImage();
        bird = new Bird();
        gameState = 0;
        lives = 1;
        tubes = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < AppConstants.numberOfTubes; i++) {
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            int topTubeOffsetY = AppConstants.minTubeOffsetY = random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);
        }
        // Initializing score in constructor.
        score = 0;
        scoringTube = 0;
        // Initializes scorePaint object that shows score.
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawTubes(Canvas canvas) {
        // Increments score when bird goes through tube
        // Scoring tube varies between 0 and 1 and can be used as an index for ArrayList
        if (gameState == 1) {
            // Detects collision with tubes
            if ((tubes.get(scoringTube).getTubeX() < bird.getBirdX() + AppConstants.getBitmapBank().getBirdWidth())
                    && (tubes.get(scoringTube).getTopTubeOffsetY() > bird.getBirdY()
                    || tubes.get(scoringTube).getBottomTubeY() < (bird.getBirdY() +
                    AppConstants.getBitmapBank().getBirdHeight()))) {
                // Go to game over screen
                gameState = 2;
                lives = 0;
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context, GameOverScreen.class);
                intent.putExtra("score", score);
                context.startActivity(intent);
                ((Activity) context).finish();
                Log.d("Game", "Over");
            } else if (tubes.get(scoringTube).getTubeX() < bird.getBirdX() - AppConstants.getBitmapBank().getTubeWidth()) {
                score++;
                scoringTube++;
                if (scoringTube > AppConstants.numberOfTubes - 1) {
                    scoringTube = 0;
                }
            }
            for (int i = 0; i < AppConstants.numberOfTubes; i++) {
                if (tubes.get(i).getTubeX() < -AppConstants.getBitmapBank().getTubeWidth()) {
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() + AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY + random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
            }
            canvas.drawText("Score: " + score, 0, 110, scorePaint);
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setBgImageX((backgroundImage.getBgImageX()) - backgroundImage.getBgImageVelocity());
        if (backgroundImage.getBgImageX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setBgImageX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBgImageX(), backgroundImage.getBgImageY(), null);
        if (backgroundImage.getBgImageX() < -AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getBgImageX() + AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getBgImageY(), null);
        }
    }

    public void updateAndDrawBird(Canvas canvas) {
        if (gameState == 1) {
            if (bird.getBirdY() < AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getBirdHeight()) {
                bird.setVelocity(bird.getVelocity() + AppConstants.gravity);
                bird.setBirdY(bird.getBirdY() + bird.getVelocity());
            }
        }
        int currentFrame = bird.getCurrentFrame();
        canvas.drawBitmap(AppConstants.getBitmapBank().getBird(currentFrame), bird.getBirdX(), bird.getBirdY(), null);
        currentFrame++;
        if (currentFrame > bird.maxFrame) {
            currentFrame = 0;
        }
        bird.setCurrentFrame(currentFrame);
    }

    public Bird getBird() {
        return bird;
    }

    public ArrayList<Tube> getTubes() {
        return tubes;
    }

    public static int getGameState() {
        return gameState;
    }

    public int getScore() {
        return score;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public static void setGameState(int gameState) {
        GameDriver.gameState = gameState;
    }

}
