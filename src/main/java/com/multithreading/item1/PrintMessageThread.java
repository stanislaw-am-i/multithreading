package com.multithreading.item1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintMessageThread extends Thread {
    private static final Logger logger = LogManager.getLogger(PrintMessageThread.class);
    private final int lines;

    public PrintMessageThread(int lines) {
        this.lines = lines;
    }

    @Override
    public void run() {
        for (int i = 0; i < lines; i++) {
            logger.info("This message number {} created by thread {}!", i, Thread.currentThread().getName());
        }
    }
}
