package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.content.Context;
import android.view.MotionEvent;

import com.example.myapplication.FlappyBirdCode.AppConstants;
import com.example.myapplication.FlappyBirdCode.Bird;
import com.example.myapplication.FlappyBirdCode.FlappyBirdGameView;




public class FlappyBirdGameViewTest {

    FlappyBirdGameView flappyBirdGameView;
    Context context;
    Bird bird;

    @Before
    public void setUp() {
        flappyBirdGameView = new FlappyBirdGameView(context);
        bird = AppConstants.getGameDriver().getBird();
    }

    /**
     * Test that the bird changes velocity on tap
     *
     * @author Emmanuel Goldin
     */
    @Test
    public void birdFlaps() {

        boolean birdFlapped;

        int newBirdVelocity = AppConstants.getVelocityAfterFirstMove();

        //MotionEvent.obtain parameters
        long downTime = 1000;
        long eventTime = 1000;
        int buttonPress = MotionEvent.ACTION_DOWN;
        int x = 1;
        int y = 1;
        int metaState = 0;

        MotionEvent clickEvent = MotionEvent.obtain(downTime, eventTime, buttonPress, x, y, metaState);
        birdFlapped = flappyBirdGameView.onTouchEvent(clickEvent);
        clickEvent.recycle();
        assertTrue(birdFlapped);
        assertEquals(newBirdVelocity, bird.getVelocity());

        //MotionEvent.obtain parameters
        downTime = 0;
        eventTime = 0;
        int noButtonPress = MotionEvent.ACTION_CANCEL;

        bird.setVelocity(0);

        MotionEvent noClickEvent = MotionEvent.obtain(downTime, eventTime, noButtonPress, x, y, metaState);
        birdFlapped = flappyBirdGameView.onTouchEvent(noClickEvent);
        noClickEvent.recycle();
        assertTrue(birdFlapped);
        assertEquals(0, bird.getVelocity());
    }
}
