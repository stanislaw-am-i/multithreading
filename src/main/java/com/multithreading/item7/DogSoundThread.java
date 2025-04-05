package com.multithreading.item7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DogSoundThread extends Thread {
    private static final Logger logger = LogManager.getLogger(DogSoundThread.class);

    @Override
    public void run() {
        logger.info("Start barking!");
        try {
            for (int i = 0; i < 10; i++) {
                logger.info("Bark bark {}!", i);
            }
        } finally {
            logger.info("Stop barking!");
        }
    }
}
