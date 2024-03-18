package com.example.myapplication;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import android.view.View;
import android.widget.Button;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Before

    /**
     * Tests that the game board initializes to an empty 3x3 array.
     */
    @Test
    public void gameBoardInitializationTest() {
        int[][] tester = new int[3][3];
        GameLogic gm = new GameLogic();
        assertArrayEquals(tester, gm.getGameBoard());
    }

    /**
     * Tests that the reset method resets the board to an empty 3x3 array and that the player
     * is reset to player 1.
     */
    @Test
    public void gameBoardResetTest() {
        int[][] tester = new int[3][3];
        GameLogic gm = new GameLogic();
        gm.resetGames();
        assertEquals(1, gm.getPlayer());
        assertArrayEquals(tester, gm.getGameBoard());
    }

    /**
     * Checks if the winner of the game is as expected.
     */
    @Test
    public void winnerTest() {
        GameLogic gameLogicTest = new GameLogic();

        assertFalse(gameLogicTest.winnerCheck());
    }

    /**
     * Tests game logic if a move has been made in the same cell.
     */
    @Test
    public void duplicateMoveTest() {
        GameLogic gm = new GameLogic();
        //gm.setPlayerTurn();
        assertTrue(gm.updateGameBoardValues(1,1));
        assertFalse(gm.updateGameBoardValues(1,1));
    }
}