package com.multithreading.item6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WalkThread extends Thread {
    private static final Logger logger = LogManager.getLogger(WalkThread.class);
    @Override
    public void run() {
        try {
            for (int i = 0; i < 777; i++) {
                logger.info("Walk " + i);
            }
        } finally {
            logger.info("The {} thread is finished", Thread.currentThread().getName());
        }
    }
}
