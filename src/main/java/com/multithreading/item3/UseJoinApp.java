package com.multithreading.item3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.multithreading.item1.CreateThreadApp;
import com.multithreading.item1.PrintMessageThread;

public class UseJoinApp {
    private static final Logger logger = LogManager.getLogger(UseJoinApp.class);

    public static void main(String[] args) {
        final int lines = 3;
        PrintMessageThread childThread = new PrintMessageThread(lines);
        childThread.start();
        try {
            childThread.join();
        } catch (InterruptedException e) {
            logger.debug(e.getMessage());
            Thread.currentThread().interrupt();            
        }
        CreateThreadApp.printMessages(lines);
    }
}
