package com.example.myapplication;

import org.junit.Test;

import com.example.myapplication.SudokuCode.BehaviorLoss;
import com.example.myapplication.SudokuCode.BehaviorWin;
import com.example.myapplication.SudokuCode.ModelStopwatch;
import org.junit.Assert;

public class ModelStopwatchTest {

    @Test
    public void testSingletonPattern() {
        ModelStopwatch stopwatch1 = ModelStopwatch.getInstance();
        ModelStopwatch stopwatch2 = ModelStopwatch.getInstance();
        Assert.assertSame(stopwatch1, stopwatch2);
    }

    @Test
    public void testElapsedTimeMeasurement() throws InterruptedException {
        ModelStopwatch stopwatch = ModelStopwatch.getInstance();
        stopwatch.start();
        Thread.sleep(1000); // Simulate some time elapsed
        stopwatch.stop();
        String report = stopwatch.getReport();
        System.out.println("Elapsed Time: " + report);
        Assert.assertTrue(report.startsWith("00:00:01"));
    }

    @Test
    public void testWinDecorator() {
        ModelStopwatch stopwatch = ModelStopwatch.getInstance();
        BehaviorWin winDecorator = new BehaviorWin(stopwatch);
        stopwatch.start();
        stopwatch.stop();
        String report = winDecorator.getReport();
        System.out.println("Win Report: " + report);
        Assert.assertTrue(report.startsWith("You WON"));
    }

    @Test
    public void testLossDecorator() {
        ModelStopwatch stopwatch = ModelStopwatch.getInstance();
        BehaviorLoss lossDecorator = new BehaviorLoss(stopwatch);
        stopwatch.start();
        stopwatch.stop();
        String report = lossDecorator.getReport();
        System.out.println("Loss Report: " + report);
        Assert.assertTrue(report.startsWith("You LOST"));
    }
}