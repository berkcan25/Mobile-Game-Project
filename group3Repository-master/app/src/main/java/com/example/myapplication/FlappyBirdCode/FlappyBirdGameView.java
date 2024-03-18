package com.example.myapplication.FlappyBirdCode;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class FlappyBirdGameView extends SurfaceView implements SurfaceHolder.Callback {

    static GameThread gameThread;
    public FlappyBirdGameView(Context context) {
        super(context);
        initView();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        if(!gameThread.isRunning()){
            gameThread = new GameThread(holder);
            gameThread.start();
        } else{
            gameThread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
            if(gameThread.isRunning()){
                gameThread.setIsRunning(false);
                boolean retry = true;
                while(retry){
                    try{
                        gameThread.join();
                        retry = false;
                    } catch(InterruptedException e){}
                }
            }
    }
    void initView() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true);
        gameThread = new GameThread(holder);
    }

    //lift the bird up after touching it
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            AppConstants.getGameDriver().gameState = 1;
            AppConstants.getGameDriver().bird.setVelocity(AppConstants.VELOCITY_AFTER_FIRST_MOVE);
        }
        return true;
    }
}
