package com.multithreading.item5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimulateInterruptionApp {
    private static final Logger logger = LogManager.getLogger(SimulateInterruptionApp.class);
    public static void main(String[] args) {
        SleepyThread sleepy = new SleepyThread();
        sleepy.start();
        try {
            sleepy.interrupt();
        } catch (Exception e) {
            logger.error(e);
        }
    }
}
