package com.multithreading.item7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CatSoundThread extends Thread {
    private static final Logger logger = LogManager.getLogger(CatSoundThread.class);

    @Override
    public void run() {
        logger.info("Start meowing!");
        try {
            Thread.yield();
            for (int i = 0; i < 10; i++) {
                logger.info("Meow {}!", i);
            }
        } finally {
            logger.info("Stop meowing!");
        }
    }
}
