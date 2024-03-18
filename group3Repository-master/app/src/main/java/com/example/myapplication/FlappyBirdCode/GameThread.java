package com.example.myapplication.FlappyBirdCode;

import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameThread extends Thread{
    SurfaceHolder surfaceHolder;
    boolean isRunning;
    long startTime, loopTime;
    long SLEEP = 33;
    public GameThread(SurfaceHolder surfaceHolder){
       this.surfaceHolder = surfaceHolder;
       isRunning = true;
    }

    @Override
    public void run(){
        while(isRunning){
            startTime = SystemClock.uptimeMillis();
            Canvas canvas = surfaceHolder.lockCanvas(null);
            if(canvas != null){
                synchronized (surfaceHolder){
                    AppConstants.getGameDriver().updateAndDrawBackgroundImage(canvas);
                    AppConstants.getGameDriver().updateAndDrawBird(canvas);
                    AppConstants.getGameDriver().updateAndDrawTubes(canvas);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            loopTime = SystemClock.uptimeMillis() - startTime;
            if(loopTime < SLEEP){
                try{
                    Thread.sleep(SLEEP - loopTime);
                } catch(InterruptedException e){
                    Log.e("Interrupted","");
                }
            }

        }
    }
    public boolean isRunning(){
        return isRunning;
    }

    public void setIsRunning(boolean state){
        isRunning = state;
    }
}
