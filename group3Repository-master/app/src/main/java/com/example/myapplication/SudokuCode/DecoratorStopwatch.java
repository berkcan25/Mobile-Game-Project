package com.example.myapplication.SudokuCode;

/**
 * (Abstract) Decorator
 * 
 * has reference to a Component object and decorate it (add or modify behavior)
 */
public abstract class DecoratorStopwatch implements ComponentStopwatch {
    protected ComponentStopwatch stopwatch;
    public DecoratorStopwatch(ComponentStopwatch stopwatch) {this.stopwatch = stopwatch;}
    @Override public void start() {stopwatch.start();}
    @Override public void stop() {stopwatch.stop();}
    @Override public String getReport() {return stopwatch.getReport();}
}