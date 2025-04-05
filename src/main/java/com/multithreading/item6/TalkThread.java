package com.multithreading.item6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TalkThread implements Runnable {

    private static final Logger logger = LogManager.getLogger(TalkThread.class);

    @Override
    public void run() {
        try {
            for (int i = 0; i < 777; i++) {
                logger.info("Talk -->" + i);
            }
        } finally {
            logger.info("The {} thread is finished", Thread.currentThread().getName());
        }
    }
}
