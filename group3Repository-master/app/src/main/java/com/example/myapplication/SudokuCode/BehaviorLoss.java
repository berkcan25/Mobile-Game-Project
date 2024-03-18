package com.example.myapplication.SudokuCode;

/**
 * Concrete Decorator
 * 
 * define extra behaviors that can be added to components dynamically.
 */
public class BehaviorLoss extends DecoratorStopwatch {
    public static final String lossMessage = "You LOST with time elapsed: ";
    public BehaviorLoss(ComponentStopwatch stopwatch) {super(stopwatch);}
    @Override public void start() {stopwatch.start();}
    @Override public void stop() {stopwatch.stop();}
    @Override public String getReport() {
        return (stopwatch.getReport().startsWith("You")) ? (stopwatch.getReport()) : (lossMessage + stopwatch.getReport());
    }
}