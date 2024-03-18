package com.example.myapplication.SudokuCode;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Concrete component
 * 
 * base object that can be decorated with additional behavior
 */
public class ModelStopwatch implements ComponentStopwatch {
    private LocalTime startTime;
    private LocalTime stopTime;

    // Singleton
    private static ModelStopwatch instance;         // Private static instance of the class
    private ModelStopwatch() {                      // Private constructor to prevent instantiation from outside the class
        startTime = LocalTime.now();
        stopTime = LocalTime.now();
    }
    public static ModelStopwatch getInstance() {    // Public static method to get the singleton instance
        if (instance == null) instance = new ModelStopwatch();
        return instance;
    }

    @Override
    public void start() {
        startTime = LocalTime.now();
        stopTime = null; // Reset stopTime when starting
    }

    @Override
    public void stop() {
        if (startTime != null) stopTime = LocalTime.now();
    }

    @Override
    public String getReport() {
        return getElapsedTime();
    }

    private String getElapsedTime() {
        LocalTime currentTime;
        if (stopTime != null) currentTime = stopTime; else currentTime = LocalTime.now();
        Duration duration = Duration.between(startTime, currentTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}