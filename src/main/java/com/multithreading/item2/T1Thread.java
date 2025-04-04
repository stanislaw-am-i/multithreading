package com.multithreading.item2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class T1Thread extends Thread {
    private static final Logger logger = LogManager.getLogger(T1Thread.class);

    public T1Thread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        logger.info("The class extends with Thread!");
    }
}
