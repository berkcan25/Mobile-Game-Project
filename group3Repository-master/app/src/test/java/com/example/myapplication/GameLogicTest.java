package com.example.myapplication;

import static org.junit.Assert.*;

import com.example.myapplication.FlappyBirdCode.AppConstants;
import com.example.myapplication.FlappyBirdCode.BackgroundImage;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GameLogicTest {
    GameLogic gm;

    /**
     * Initializes the declared GameLogic variable above.
     */
    @Before
    public void setup() {
        gm = new GameLogic();
    }

    /**
     * Test to ensure board allows moves on every cell initially
     * and once a cell is filled, it does not allow to fill again in the same game.
     *
     * @author Vivek Bumb
     */
    @Test
    public void testBoard() {
        /*
        Initially all cells will be empty and player should be able to fill out X or O on
        each of the empty cell.
        */
        for (int row = 0; row < gm.getGameBoard().length; row++) {
            for (int col = 0; col < gm.getGameBoard()[row].length; col++) {
                assert (gm.updateGameBoardValues(row + 1, col + 1));
            }
        }
        /*
        At this step all cells will be filled and we want to test that once a cell is filled,
        it cannot be filled again even if player clicks it again.
        */
        for (int row = 0; row < gm.getGameBoard().length; row++) {
            for (int col = 0; col < gm.getGameBoard()[row].length; col++) {
                assert (!gm.updateGameBoardValues(row + 1, col + 1));
            }
        }
    }

    /***
     * Test to ensure reset method made every element 0.
     * First we set all values to 1 and then we call resetGameBordValues method
     * after resetGameBordValues method is executed every value should be 0.
     *
     * @author Vivek Bumb
     */
    @Test
    public void testResetGames() {
        GameLogic test = new GameLogic();
        int[][] gmBoard = new int[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gmBoard[r][c] = 1;
            }
        }
        /*
        Sets the gameBoard of a GameLogic object to a full 3x3 array and asserts that it is
        NOT equal to an empty gameBoard.
        */
        test.setGameBoard(gmBoard);
        assertFalse(Arrays.equals(gm.getGameBoard(), test.getGameBoard()));

        /*
        Resets the gameBoard values back to all 0s and asserts that it IS equal to an empty
        gameBoard.
        */
        test.resetGameBoardValues();
        assertArrayEquals(gm.getGameBoard(), test.getGameBoard());
    }

    /**
     * Test to ensure winnerCheck checks the win and tie board states accurately.
     *
     * @author Berk Tunctan
     */
    @Test
    public void testWinnerCheck() {
        boolean isWinner;
        boolean isTied;

        int[][] wonGameBoard = new int[3][3];
        int[][] tiedGameBoard = new int[3][3];

        //create a board with top row of full x's
        //[x,x,x]
        //[0,0,0]
        //[0,0,0]
        wonGameBoard[0][0] = 1;
        wonGameBoard[0][1] = 1;
        wonGameBoard[0][2] = 1;

        //create a tied game with the following configuration
        //[o,x,x]
        //[x,x,o]
        //[o,o,x]
        tiedGameBoard[0][0] = 2;
        tiedGameBoard[0][1] = 1;
        tiedGameBoard[0][2] = 1;
        tiedGameBoard[1][0] = 1;
        tiedGameBoard[1][1] = 1;
        tiedGameBoard[1][2] = 2;
        tiedGameBoard[2][0] = 2;
        tiedGameBoard[2][1] = 2;
        tiedGameBoard[2][2] = 1;

        gm.setGameBoard(wonGameBoard);
        isWinner = gm.hasWon();
        assertTrue(isWinner);

        gm.setGameBoard(tiedGameBoard);
        isTied = gm.hasWon();
        assertFalse(isTied);
    }

    /**
     * Tests that the updateGameBoard functionality works as intended.
     *
     * @author Berk Tunctan
     */
    @Test
    public void testUpdateGameBoard() {
        int player = gm.getPlayer();

        assertEquals("The player is 1", 1, player);
        int[][] completeGameBoard = new int[3][3];
        int[][] incompleteGameBoard = new int[3][3];

        //create a game with the following configuration
        //[o,x,x]
        //[x,x,o]
        //[o,o,x]
        completeGameBoard[0][0] = 2;
        completeGameBoard[0][1] = 1;
        completeGameBoard[0][2] = 1;
        completeGameBoard[1][0] = 1;
        completeGameBoard[1][1] = 1;
        completeGameBoard[1][2] = 2;
        completeGameBoard[2][0] = 2;
        completeGameBoard[2][1] = 2;
        completeGameBoard[2][2] = 1;

        int row, col;
        row = 3;
        col = 3;

        gm.setGameBoard(completeGameBoard);
        assertFalse("The board should not update", gm.updateGameBoardValues(row, col));
        gm.setGameBoard(incompleteGameBoard);
        assertTrue("The board should update", gm.updateGameBoardValues(row, col));
    }

    /**
     * Tests the functionality for a "diagonal" win.
     *
     * @author Jeongyeop Han
     */
    @Test
    public void testDiagonalWin() {
        /* Initializes a gameBoard array representing a diagonal win from top left
        down to bottom right.
        */
        int[][] gameBoard = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        gm.setGameBoard(gameBoard);
        assertTrue(gm.hasWon());
        int[] expectedWinType = {0, 2, 3};
        assertArrayEquals(expectedWinType, gm.getWinType());
    }

    /**
     * Tests the functionality for a "horizontal" win.
     *
     * @author Jeongyeop Han
     */
    @Test
    public void testHorizontalWin() {
        //Initializes a gameBoard array representing a horizontal win on the uppermost horizontal.
        int[][] gameBoard = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        gm.setGameBoard(gameBoard);
        assertTrue(gm.hasWon());
        int[] expectedWinType = {0, 0, 1};
        assertArrayEquals(expectedWinType, gm.getWinType());
    }

    /**
     * Tests the functionality for a "vertical" win.
     *
     * @author Charles Wyner
     */
    @Test
    public void testVerticalWin() {
        // Initializes a gameBoard array representing a vertical win on the leftmost vertical.
        int[][] gameBoard = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
        };
        gm.setGameBoard(gameBoard);
        assertTrue(gm.hasWon());
        int[] expectedWinType = {0, 0, 2};
        assertArrayEquals(expectedWinType, gm.getWinType());
    }

    /**
     * Tests that the gameBoard of a GameLogic object initializes to an empty 3x3 array.
     *
     * @author Charles Wyner
     */
    @Test
    public void testGameBoardInitialization() {
        //Initializes empty 3x3 array
        int[][] tester = new int[3][3];
        assertArrayEquals(tester, gm.getGameBoard());
    }

    /**
     * Tests game logic for updateGameBoardValues when updating values in same cell.
     *
     * @author Andrew Kim
     */
    @Test
    public void testDuplicateMove() {
        // Makes 2 sets of duplicate moves, returns true for valid move and false for invalid move.
        assertTrue(gm.updateGameBoardValues(1, 1));
        assertFalse(gm.updateGameBoardValues(1, 1));
        assertTrue(gm.updateGameBoardValues(1, 2));
        assertFalse(gm.updateGameBoardValues(1, 2));

        // Makes 2 independent valid moves.
        assertTrue(gm.updateGameBoardValues(1, 3));
        assertTrue(gm.updateGameBoardValues(3, 1));
    }

    /**
     * Tests the functionality for a win by player2.
     *
     * @author Andrew Kim
     */
    @Test
    public void testPlayer2Win() {
        String[] playerNames = {"Player 1", "Player 2"};
        // Initializes a gameBoard array representing a win for player 2.
        int[][] gameBoard = {
                {2, 0, 0},
                {2, 0, 0},
                {2, 0, 0}
        };
        gm.setGameBoard(gameBoard);
        assertTrue(gm.hasWon());
        assertEquals("Player 2 Won!!!", playerNames[gm.getPlayer()] + " Won!!!");
    }

    /**
     * Tests that the isBoardFilled variable is updated when there is a tied game
     * AND that the hasWon() method returns false.
     *
     * @author Manny Goldin
     */
    @Test
    public void testIsBoardFilled() {
        int[][] filledGameBoard = {
                {2, 1, 2},
                {2, 1, 1},
                {1, 2, 1}
        };
        gm.setGameBoard(filledGameBoard);
        assertFalse(gm.hasWon());
        assertTrue(gm.getIsBoardFilled());
    }

    /**
     * Tests that a GameLogic object is never null, even when it is reset and updated.
     *
     * @author Manny Goldin
     */
    @Test
    public void testNulls() {
        assertNotNull(gm);
        assertNotNull(gm.getGameBoard());
        int[][] gameBoard = {
                {2, 0, 0},
                {2, 0, 0},
                {2, 0, 0}
        };
        gm.setGameBoard(gameBoard);
        assertNotNull(gm);
        assertNotNull(gm.getGameBoard());
        gm.resetGameBoardValues();
        assertNotNull(gm);
        assertNotNull(gm.getGameBoard());
    }

    /**
     * Test to ensure background image velocity is set as 3 initially for flappy bird game
     *
     * @author Vivek Bumb
     */
    @Test
    public void testFlappyBirdBackgroundScreenVelocity(){
        BackgroundImage bg = new BackgroundImage();
        assertEquals(3,bg.getBgImageVelocity());
    }

    /**
     * Test to ensure initial setup values of flappy bird game are set with constants as required
     *
     * @author Vivek Bumb
     */
    @Test
    public void testFlappyBirdInitialGameSetUpValues(){
        AppConstants.setGameConstants();
        assertEquals(3,AppConstants.getGravity());
        assertEquals(2,AppConstants.getNumberOfTubes());
        assertEquals(-40,AppConstants.getVelocityAfterFirstMove());
        assertEquals(600,AppConstants.getGapBetweenTopAndBottomTubes());
        assertEquals(12,AppConstants.getTubeVelocity());
    }

}