//package com.example.myapplication;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//import android.graphics.Canvas;
//import android.view.SurfaceHolder;
//import android.view.View;
//
//import com.example.myapplication.FlappyBirdCode.AppConstants;
//import com.example.myapplication.FlappyBirdCode.BackgroundImage;
//import com.example.myapplication.FlappyBirdCode.Bird;
//import com.example.myapplication.FlappyBirdCode.GameDriver;
//import com.example.myapplication.FlappyBirdCode.GameOverScreen;
//import com.example.myapplication.FlappyBirdCode.Tube;
//
//import java.util.ArrayList;
//
//
//public class GameDriverTest {
//
//    GameDriver gd;
//    Bird bird;
//    ArrayList<Tube> tubes;
//
//    SurfaceHolder surfaceHolder;
//    Canvas canvas;
//
//    /**
//     * Initializes the previously declared GameDriver variable
//     */
//    @Before
//    public void setUp() {
//        gd = new GameDriver();
//        bird = gd.getBird();
//        tubes = gd.getTubes();
//        canvas = surfaceHolder.lockCanvas(null);
//    }
//
//    /**
//     * Checks if the game driver initialized correctly
//     *
//     * @author Berk Can Tunctan
//     */
//    @Test
//    public void testGameDriverInitialization() {
//        int gameState = 0;
//        //Bird is not null
//        assertNotNull(bird);
//
//        //Tubes are not null
//        assertNotNull(tubes);
//
//        //Correct number of Tubes
//        assertEquals(AppConstants.getNumberOfTubes(), tubes.size());
//    }
//
//    /**
//     * [Additionally, SOLID principle applied] Checks if the initial game state is set to 0
//     *
//     * @author Jaehoon Song
//     */
//    @Test
//    public void testInitialGameState() {
//        int expectedGameState = 0;
//        int actualGameState = gd.getGameState();
//        assertEquals(expectedGameState, actualGameState);
//    }
//
//    /**
//     * Checks if gameState is updated when bird collides with tube
//     *
//     * @author Berk Can Tunctan
//     */
//    @Test
//    public void testBirdDeath() {
//
//        int survivedGameState = 1;
//        int gameActivityGameState = 1;
//
//        GameDriver.setGameState(gameActivityGameState);
//
//        Bird aliveBird = new Bird();
//
//        int tubeX = tubes.get(0).getTubeX();
//        int topTubeOffsetY = tubes.get(0).getTopTubeOffsetY();
//        int bottomTubeY = tubes.get(0).getBottomTubeY();
//
//        aliveBird.setBirdX(tubeX);
//        aliveBird.setBirdY(bottomTubeY);
//
//        gd.setBird(aliveBird);
//        gd.updateAndDrawTubes(canvas);
//        assertEquals(survivedGameState, GameDriver.getGameState());
//    }
//
//    /**
//     * [Additionally, SOLID principle applied] Checks if the game state is
//     * correctly set to death when the bird collides with a tube
//     *
//     * @author Jaehoon Song
//     */
//    @Test
//    public void testGameStateAfterBirdDeath() {
//        int gameActivityGameState = 1;
//        gd.setGameState(gameActivityGameState);
//
//        Bird dyingBird = new Bird();
//
//        int tubeX = tubes.get(0).getTubeX();
//        int topTubeOffsetY = tubes.get(0).getTopTubeOffsetY();
//
//        dyingBird.setBirdX(tubeX);
//        dyingBird.setBirdY(topTubeOffsetY - 1);
//
//        gd.setBird(dyingBird);
//        gd.updateAndDrawTubes(canvas);
//        assertEquals(2, gd.getGameState());
//    }
//
//    /**
//     * Test for updating the score when bird passes through tube
//     *
//     * @author Emmanuel Goldin
//     */
//    @Test
//    public void testScoreUpdate() {
//        int gameActivityGameState = 1;
//        GameDriver.setGameState(gameActivityGameState);
//
//        int originalScore = gd.getScore();
//
//        int tubeX = tubes.get(0).getTubeX();
//        int bottomTubeY = tubes.get(0).getBottomTubeY();
//
//        bird.setBirdX(tubeX + AppConstants.getBitmapBank().getTubeWidth());
//        bird.setBirdY(bottomTubeY);
//
//        gd.updateAndDrawTubes(canvas);
//
//        //true if the score updated at least once.
//        assertTrue(originalScore < gd.getScore());
//    }
//
//    /**
//     * Test to ensure background image velocity is set as 3 initially for flappy bird game
//     *
//     * @author Vivek Bumb
//     */
//    @Test
//    public void testFlappyBirdBackgroundScreenVelocity() {
//        BackgroundImage bg = new BackgroundImage();
//        assertEquals(3, bg.getBgImageVelocity());
//    }
//
//    /**
//     * Test to ensure initial setup values of flappy bird game are set with constants as required
//     *
//     * @author Vivek Bumb
//     */
//    @Test
//    public void testFlappyBirdInitialGameSetUpValues() {
//        AppConstants.setGameConstants();
//        assertEquals(3, AppConstants.getGravity());
//        assertEquals(2, AppConstants.getNumberOfTubes());
//        assertEquals(-40, AppConstants.getVelocityAfterFirstMove());
//        assertEquals(600, AppConstants.getGapBetweenTopAndBottomTubes());
//        assertEquals(12, AppConstants.getTubeVelocity());
//    }
//
//    /**
//     * Tests that the number of lives goes to 0 when the bird dies.
//     *
//     * @author Charles Wyner
//     */
//    @Test
//    public void testLivesTo0() {
//        if (gd.getGameState() == 2) {
//            assertEquals(0, gd.getLives());
//        }
//    }
//
//    /**
//     * Tests that the number of lives is 1 when the game begins and when it's reset.
//     *
//     * @author Charles Wyner
//     */
//    @Test
//    public void testLivesOnBeginAndReset() {
//        if (gd.getGameState() == 1) {
//            assertEquals(1, gd.getLives());
//        }
//    }
//
//    /**
//     * [Additionally, SOLID principle applied] Checks if the initial game state is set to 0
//     *
//     * @author Jaehoon Song
//     */
//    @Test
//    public void testInitialGameState() {
//        int expectedGameState = 0;
//        int actualGameState = gd.getGameState();
//        assertEquals(expectedGameState, actualGameState);
//    }
//
//    /**
//     * [Additionally, SOLID principle applied] Checks if the game state is
//     * correctly set to death when the bird collides with a tube
//     *
//     * @author Jaehoon Song
//     */
//    @Test
//    public void testGameStateAfterBirdDeath() {
//        int gameActivityGameState = 1;
//        gd.setGameState(gameActivityGameState);
//
//        Bird dyingBird = new Bird();
//
//        int tubeX = tubes.get(0).getTubeX();
//        int topTubeOffsetY = tubes.get(0).getTopTubeOffsetY();
//
//        dyingBird.setBirdX(tubeX);
//        dyingBird.setBirdY(topTubeOffsetY - 1);
//
//        gd.setBird(dyingBird);
//        gd.updateAndDrawTubes(canvas);
//        assertEquals(2, gd.getGameState());
//    }
//}
//
