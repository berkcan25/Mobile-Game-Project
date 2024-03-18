package com.example.myapplication.SudokuCode;

/**
 * (Abstract) Component
 * 
 * defines "common behavior" of base object
 */
public interface ComponentStopwatch {
    void start();
    void stop();
    String getReport();
}