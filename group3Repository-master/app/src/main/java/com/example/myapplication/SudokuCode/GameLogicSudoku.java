package com.example.myapplication.SudokuCode;

import java.util.HashSet;
import java.util.Set;

public class GameLogicSudoku {
    private Cell[][] table;
    private String sudokuGameBoard;
    private int randomNumber;

    /**
     * Constructor for GameLogicSudoku object.
     *
     * @param randomNumber takes in an int that determines the layout of the board.
     */
    public GameLogicSudoku(int randomNumber) {
        this.randomNumber = randomNumber;
        table = new Cell[9][9];
        setSudokuGameBoard();
    }

    /**
     * Sets the layout of game board based on random number generated.
     */
    private void setSudokuGameBoard() {
        if (this.randomNumber == 1) {
            this.sudokuGameBoard = "6 8 5 7 4 9 2 1 3 " +
                    "3 1 2 5 8 6 ? 7 9 " +
                    "9 4 7 3 1 2 5 6 8 " +
                    "7 2 ? 6 9 8 3 4 5 " +
                    "5 3 9 2 7 4 6 8 1 " +
                    "8 6 4 1 5 3 9 2 7 " +
                    "2 9 8 4 3 1 7 5 6 " +
                    "1 5 6 9 2 ? 8 3 4 " +
                    "4 7 3 8 6 5 1 9 2 ";
        } else if (randomNumber == 2) {
            sudokuGameBoard = "4 6 7 9 2 1 3 5 8 " +
                    "8 9 5 4 7 3 2 6 1 " +
                    "2 3 1 8 ? 5 7 4 9 " +
                    "5 1 3 6 9 8 4 2 7 " +
                    "9 2 8 7 5 4 6 1 3 " +
                    "7 4 ? 1 3 2 9 8 5 " +
                    "3 5 4 2 8 7 1 9 6 " +
                    "1 8 9 3 4 6 5 7 2 " +
                    "6 7 2 5 1 9 8 3 4 ";
        } else {
            sudokuGameBoard = "3 8 7 5 2 1 9 6 4 " +
                    "5 ? 2 6 3 9 1 7 8 " +
                    "9 1 6 4 8 7 5 2 3 " +
                    "7 6 8 1 4 5 2 3 9 " +
                    "2 3 1 9 ? 8 4 5 ? " +
                    "4 9 5 3 6 2 7 8 1 " +
                    "6 2 9 8 5 4 3 1 7 " +
                    "? 7 3 2 9 6 8 4 5 " +
                    "8 5 4 7 1 3 6 9 2 ";
        }
    }

    /**
     * Method that determines if a game board has been entirely filled out.
     *
     * @param gameBoard game board to be analyzed
     * @return true if game board has been completed
     */
    public static boolean completed(int[][] gameBoard) {
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                if (gameBoard[i][j] == 0)
                    return false;
        return true;
    }

    /**
     * Method that determines if the game board has been solved correctly.
     *
     * @param gameBoard game board to be analyzed
     * @return true if completed correctly
     */
    public static boolean isSudokuSolvedCorrectly(int[][] gameBoard) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                int number = gameBoard[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i / 3 + "-" + j / 3))
                        return false;
            }
        }
        return true; // return value
    }

    /**
     * Getter method for the table.
     *
     * @return table
     */
    public Cell[][] getTable() {
        return table;
    }

    /**
     * Setter method for the table.
     *
     * @param table table to be set
     */
    public void setTable(Cell[][] table) {
        this.table = table;
    }

    /**
     * Getter method for the random number.
     *
     * @return random number int
     */
    public int getRandomNumber() {
        return randomNumber;
    }

    /**
     * Setter method for the "random" number, used only for simulation purposes.
     *
     * @param randomNumber "random" number
     */
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    /**
     * Getter method for sudoku game board.
     *
     * @return sudokuGameBoard
     */
    public String getSudokuGameBoard() {
        return sudokuGameBoard;
    }

    /**
     * Setter method for sudoku game board.
     *
     * @param sudokuGameBoard the sudoku game board
     */
    public void setSudokuGameBoard(String sudokuGameBoard) {
        this.sudokuGameBoard = sudokuGameBoard;
    }
}
