package com.example.myapplication.FlappyBirdCode;

import android.content.Context;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapBank;
    static GameDriver gameDriver;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_AFTER_FIRST_MOVE;
    static int gapBetweenTopAndBottomTubes;
    static int numberOfTubes;
    static int tubeVelocity;
    static int minTubeOffsetY;
    static int maxTubeOffsetY;
    static int distanceBetweenTubes;
    static Context gameActivityContext;

    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = BitmapBank.getInstance(context.getResources());
        setGameConstants();
        gameDriver = new GameDriver();

    }

    public static void setGameConstants() {
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_AFTER_FIRST_MOVE = -40;
        gapBetweenTopAndBottomTubes = 600;
        AppConstants.numberOfTubes = 2;
        AppConstants.tubeVelocity = 12;
        AppConstants.minTubeOffsetY = (int) (AppConstants.gapBetweenTopAndBottomTubes / 2.0);
        AppConstants.maxTubeOffsetY = AppConstants.SCREEN_HEIGHT - AppConstants.minTubeOffsetY - AppConstants.gapBetweenTopAndBottomTubes;
        AppConstants.distanceBetweenTubes = AppConstants.SCREEN_WIDTH * 3 / 4;
    }

    public static int getGravity() {
        return gravity;
    }

    public static int getVelocityAfterFirstMove() {
        return VELOCITY_AFTER_FIRST_MOVE;
    }

    public static int getGapBetweenTopAndBottomTubes() {
        return gapBetweenTopAndBottomTubes;
    }

    public static int getNumberOfTubes() {
        return numberOfTubes;
    }

    public static int getTubeVelocity() {
        return tubeVelocity;
    }

    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    public static GameDriver getGameDriver(){
        return gameDriver;
    }

    //Set the size to cover complete background image.
    private static void setScreenSize(Context context){
        WindowManager w = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = w.getDefaultDisplay();
        DisplayMetrics m = new DisplayMetrics();
        display.getMetrics(m);
        int width = m.widthPixels;
        int height = m.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }
}
