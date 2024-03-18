package com.example.myapplication.SudokuCode;

public class Cell {
    int value;
    int randomNumber;
    boolean fixed;
    private static Cell cell;
    private Cell() {}

    public Cell(int initvalue) {
        value = initvalue;
        if (value != 0) fixed = true;
        else fixed = false;
    }

    public int getValue() {
        return value;
    }

    public static Cell getInstance() {
        if (cell == null) {
                    return new Cell();
        }
        return cell;
    }

//    public void setRandomNumber(int randomNumber) {
//        this.randomNumber = randomNumber;
//    }
//
//    public int getRandomNumber() {
//        return randomNumber;
//    }
}
//}
