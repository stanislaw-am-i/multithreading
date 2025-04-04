package com.multithreading.item4;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintStringSequenceThread extends Thread {
    private static final Logger logger = LogManager.getLogger(PrintStringSequenceThread.class);
    private final List<String> stringSequence;
    public PrintStringSequenceThread(List<String> stringSequence) {
        this.stringSequence = stringSequence;
    }
    @Override
    public void run() {
        logger.info("This message created by thread {}!", Thread.currentThread().getName());
        for (String s : stringSequence) {
            logger.info(s);
        }
    }
}
