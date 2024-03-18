package com.example.myapplication.SudokuCode;

/**
 * Concrete Decorator
 * 
 * define extra behaviors that can be added to components dynamically.
 */
public class BehaviorWin extends DecoratorStopwatch {
    public static final String winMessage = "You WON with time elapsed: ";
    public BehaviorWin(ComponentStopwatch stopwatch) { super(stopwatch); }
   // @Override public void start() {stopwatch.start();}
    @Override public void stop() {stopwatch.stop();}
    @Override public String getReport() {
        return (stopwatch.getReport().startsWith("You")) ? (stopwatch.getReport()) : (winMessage + stopwatch.getReport());
    }
}