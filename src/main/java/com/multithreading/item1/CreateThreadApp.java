package com.multithreading.item1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateThreadApp {
    private static final Logger logger = LogManager.getLogger(CreateThreadApp.class);

    public static void main(String[] args) {
        final int lines = 3;
        PrintMessageThread childThread = new PrintMessageThread(lines);
        childThread.start();
        printMessages(lines);
    }

    public static void printMessages(int lines) {
        for (int i = 0; i < lines; i++) {
            logger.info("This message number {} created by parent thread!", i);
        }
    }
}
