package com.example.myapplication;

import static com.example.myapplication.SudokuCode.GameLogicSudoku.completed;
import static com.example.myapplication.SudokuCode.GameLogicSudoku.isSudokuSolvedCorrectly;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.myapplication.SudokuCode.Cell;
import com.example.myapplication.SudokuCode.GameLogicSudoku;

import org.junit.Before;
import org.junit.Test;

public class SudokuUnitTests {
    private GameLogicSudoku gameLogicSudoku;

    @Before
    public void setup() {
        gameLogicSudoku = new GameLogicSudoku(0);
    }

    /**
     * Tests that the game board initializes to an empty 9 x 9 array.
     */
    @Test
    public void initializationTest() {
        Cell[][] tester = new Cell[9][9];
        assertArrayEquals(tester, gameLogicSudoku.getTable());
    }

    /**
     * Tests to see if a win has been determined correctly for game board layout type 1.
     */
    @Test
    public void gameBoardType1WinnerTest() {
        int[][] gameBoard = {
                {6, 8, 5, 7, 4, 9, 2, 1, 3},
                {3, 1, 2, 5, 8, 6, 4, 7, 9},
                {9, 4, 7, 3, 1, 2, 5, 6, 8},
                {7, 2, 1, 6, 9, 8, 3, 4, 5},
                {5, 3, 9, 2, 7, 4, 6, 8, 1},
                {8, 6, 4, 1, 5, 3, 9, 2, 7},
                {2, 9, 8, 4, 3, 1, 7, 5, 6},
                {1, 5, 6, 9, 2, 7, 8, 3, 4},
                {4, 7, 3, 8, 6, 5, 1, 9, 2}
        };
        assertTrue(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a win has been determined correctly for game board layout type 2.
     */
    @Test
    public void gameBoardType2WinnerTest() {
        int[][] gameBoard = {
                {4, 6, 7, 9, 2, 1, 3, 5, 8},
                {8, 9, 5, 4, 7, 3, 2, 6, 1},
                {2, 3, 1, 8, 6, 5, 7, 4, 9},
                {5, 1, 3, 6, 9, 8, 4, 2, 7},
                {9, 2, 8, 7, 5, 4, 6, 1, 3},
                {7, 4, 6, 1, 3, 2, 9, 8, 5},
                {3, 5, 4, 2, 8, 7, 1, 9, 6},
                {1, 8, 9, 3, 4, 6, 5, 7, 2},
                {6, 7, 2, 5, 1, 9, 8, 3, 4}
        };
        assertTrue(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a win has been determined correctly for game board layout type 3.
     */
    @Test
    public void gameBoardType3WinnerTest() {
        int[][] gameBoard = {
                {3, 8, 7, 5, 2, 1, 9, 6, 4},
                {5, 4, 2, 6, 3, 9, 1, 7, 8},
                {9, 1, 6, 4, 8, 7, 5, 2, 3},
                {7, 6, 8, 1, 4, 5, 2, 3, 9},
                {2, 3, 1, 9, 7, 8, 4, 5, 6},
                {4, 9, 5, 3, 6, 2, 7, 8, 1},
                {6, 2, 9, 8, 5, 4, 3, 1, 7},
                {1, 7, 3, 2, 9, 6, 8, 4, 5},
                {8, 5, 4, 7, 1, 3, 6, 9, 2}
        };
        assertTrue(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests an arbitrary game board set up for a correct solution, showing game logic
     * code can be used for more than just the 3 setups we have implemented.
     */
    @Test
    public void arbitraryWinnerTest() {
        int[][] gameBoard = {
                {7, 3, 5, 6, 1, 4, 8, 9, 2},
                {8, 4, 2, 9, 7, 3, 5, 6, 1},
                {9, 6, 1, 2, 8, 5, 3, 7, 4},
                {2, 8, 6, 3, 4, 9, 1, 5, 7},
                {4, 1, 3, 8, 5, 7, 9, 2, 6},
                {5, 7, 9, 1, 2, 6, 4, 3, 8},
                {1, 5, 7, 4, 9, 2, 6, 8, 3},
                {6, 9, 4, 7, 3, 8, 2, 1, 5},
                {3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        assertTrue(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a loss has been determined correctly for game board type 1.
     */
    @Test
    public void gameBoardType1LoserTest() {
        // Incorrect solution is in top row
        int[][] gameBoard = {
                {6, 8, 5, 7, 4, 9, 1, 1, 3},
                {3, 1, 2, 5, 8, 6, 4, 7, 9},
                {9, 4, 7, 3, 1, 2, 5, 6, 8},
                {7, 2, 1, 6, 9, 8, 3, 4, 5},
                {5, 3, 9, 2, 7, 4, 6, 8, 1},
                {8, 6, 4, 1, 5, 3, 9, 2, 7},
                {2, 9, 8, 4, 3, 1, 7, 5, 6},
                {1, 5, 6, 9, 2, 7, 8, 3, 4},
                {4, 7, 3, 8, 6, 5, 1, 9, 2}
        };
        assertFalse(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a loss has been determined correctly for game board type 2.
     */
    @Test
    public void gameBoardType2LoserTest() {
        // Incorrect solution is in top row
        int[][] gameBoard = {
                {4, 6, 7, 9, 2, 1, 1, 5, 8},
                {8, 9, 5, 4, 7, 3, 2, 6, 1},
                {2, 3, 1, 8, 6, 5, 7, 4, 9},
                {5, 1, 3, 6, 9, 8, 4, 2, 7},
                {9, 2, 8, 7, 5, 4, 6, 1, 3},
                {7, 4, 6, 1, 3, 2, 9, 8, 5},
                {3, 5, 4, 2, 8, 7, 1, 9, 6},
                {1, 8, 9, 3, 4, 6, 5, 7, 2},
                {6, 7, 2, 5, 1, 9, 8, 3, 4}
        };
        assertFalse(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a loss has been determined correctly for game board type 3.
     */
    @Test
    public void gameBoardType3LoserTest() {
        // Incorrect solution is in top row
        int[][] gameBoard = {
                {3, 8, 7, 5, 2, 1, 1, 6, 4},
                {5, 4, 2, 6, 3, 9, 1, 7, 8},
                {9, 1, 6, 4, 8, 7, 5, 2, 3},
                {7, 6, 8, 1, 4, 5, 2, 3, 9},
                {2, 3, 1, 9, 7, 8, 4, 5, 6},
                {4, 9, 5, 3, 6, 2, 7, 8, 1},
                {6, 2, 9, 8, 5, 4, 3, 1, 7},
                {1, 7, 3, 2, 9, 6, 8, 4, 5},
                {8, 5, 4, 7, 1, 3, 6, 9, 2}
        };
        assertFalse(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a loss has been determined correctly for a game board of arbitrary
     * set up to show that game logic code can be used for more than just the 3 setups we
     * have implemented.
     */
    @Test
    public void arbitraryLoserTest() {
        // Incorrect solution is in top row
        int[][] gameBoard = {
                {7, 3, 5, 6, 1, 1, 8, 9, 2},
                {8, 4, 2, 9, 7, 3, 5, 6, 1},
                {9, 6, 1, 2, 8, 5, 3, 7, 4},
                {2, 8, 6, 3, 4, 9, 1, 5, 7},
                {4, 1, 3, 8, 5, 7, 9, 2, 6},
                {5, 7, 9, 1, 2, 6, 4, 3, 8},
                {1, 5, 7, 4, 9, 2, 6, 8, 3},
                {6, 9, 4, 7, 3, 8, 2, 1, 5},
                {3, 2, 8, 5, 6, 1, 7, 4, 9}
        };
        assertFalse(isSudokuSolvedCorrectly(gameBoard));
    }

    /**
     * Tests to see if a game board has been completed, regardless of correctness.
     */
    @Test
    public void completedTest() {
        int[][] completedAndCorrect = {
                {6, 8, 5, 7, 4, 9, 2, 1, 3},
                {3, 1, 2, 5, 8, 6, 4, 7, 9},
                {9, 4, 7, 3, 1, 2, 5, 6, 8},
                {7, 2, 1, 6, 9, 8, 3, 4, 5},
                {5, 3, 9, 2, 7, 4, 6, 8, 1},
                {8, 6, 4, 1, 5, 3, 9, 2, 7},
                {2, 9, 8, 4, 3, 1, 7, 5, 6},
                {1, 5, 6, 9, 2, 7, 8, 3, 4},
                {4, 7, 3, 8, 6, 5, 1, 9, 2}
        };
        assertTrue(completed(completedAndCorrect));

        int[][] completedButIncorrect = {
                {6, 8, 5, 7, 4, 9, 1, 1, 3},
                {3, 1, 2, 5, 8, 6, 4, 7, 9},
                {9, 4, 7, 3, 1, 2, 5, 6, 8},
                {7, 2, 1, 6, 9, 8, 3, 4, 5},
                {5, 3, 9, 2, 7, 4, 6, 8, 1},
                {8, 6, 4, 1, 5, 3, 9, 2, 7},
                {2, 9, 8, 4, 3, 1, 7, 5, 6},
                {1, 5, 6, 9, 2, 7, 8, 3, 4},
                {4, 7, 3, 8, 6, 5, 1, 9, 2}
        };
        assertTrue(completed(completedButIncorrect));
    }

    /**
     * Tests to see that a game board has not been completed (denoted with a 0 in the empty cell).
     */
    @Test
    public void incompleteTest() {
        int[][] gameBoard = {
                {6, 8, 5, 7, 4, 9, 0, 1, 3},
                {3, 1, 2, 5, 8, 6, 4, 7, 9},
                {9, 4, 7, 3, 1, 2, 5, 6, 8},
                {7, 2, 1, 6, 9, 8, 3, 4, 5},
                {5, 3, 9, 2, 7, 4, 6, 8, 1},
                {8, 6, 4, 1, 5, 3, 9, 2, 7},
                {2, 9, 8, 4, 3, 1, 7, 5, 6},
                {1, 5, 6, 9, 2, 7, 8, 3, 4},
                {4, 7, 3, 8, 6, 5, 1, 9, 2}
        };
        assertFalse(completed(gameBoard));
    }

    /**
     * Tests the layout of the game board when random number is 1.
     */
    @Test
    public void gameBoardTypeGeneration1Test() {
        int randomNumber = 1;
        GameLogicSudoku gameLogicSudoku1 = new GameLogicSudoku(randomNumber);
        assertEquals(("6 8 5 7 4 9 2 1 3 " +
                    "3 1 2 5 8 6 ? 7 9 " +
                    "9 4 7 3 1 2 5 6 8 " +
                    "7 2 ? 6 9 8 3 4 5 " +
                    "5 3 9 2 7 4 6 8 1 " +
                    "8 6 4 1 5 3 9 2 7 " +
                    "2 9 8 4 3 1 7 5 6 " +
                    "1 5 6 9 2 ? 8 3 4 " +
                    "4 7 3 8 6 5 1 9 2 "), gameLogicSudoku1.getSudokuGameBoard());
    }

    /**
     * Tests the layout of the game board when random number is 2.
     */
    @Test
    public void gameBoardTypeGeneration2Test() {
        int randomNumber = 2;
        GameLogicSudoku gameLogicSudoku2 = new GameLogicSudoku(randomNumber);
        assertEquals(("4 6 7 9 2 1 3 5 8 " +
                "8 9 5 4 7 3 2 6 1 " +
                "2 3 1 8 ? 5 7 4 9 " +
                "5 1 3 6 9 8 4 2 7 " +
                "9 2 8 7 5 4 6 1 3 " +
                "7 4 ? 1 3 2 9 8 5 " +
                "3 5 4 2 8 7 1 9 6 " +
                "1 8 9 3 4 6 5 7 2 " +
                "6 7 2 5 1 9 8 3 4 "), gameLogicSudoku2.getSudokuGameBoard());
    }

    /**
     * Tests the layout of the game board when random number is 3.
     */
    @Test
    public void gameBoardTypeGeneration3Test() {
        int randomNumber = 3;
        GameLogicSudoku gameLogicSudoku3 = new GameLogicSudoku(randomNumber);
        assertEquals(("3 8 7 5 2 1 9 6 4 " +
                "5 ? 2 6 3 9 1 7 8 " +
                "9 1 6 4 8 7 5 2 3 " +
                "7 6 8 1 4 5 2 3 9 " +
                "2 3 1 9 ? 8 4 5 ? " +
                "4 9 5 3 6 2 7 8 1 " +
                "6 2 9 8 5 4 3 1 7 " +
                "? 7 3 2 9 6 8 4 5 " +
                "8 5 4 7 1 3 6 9 2 "), gameLogicSudoku3.getSudokuGameBoard());
    }
}
