package com.multithreading.item2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class T2Runnable implements Runnable {
    private static final Logger logger = LogManager.getLogger(T2Runnable.class);

    @Override
    public void run() {
        logger.info("This is runnable!");
    }
    
}
