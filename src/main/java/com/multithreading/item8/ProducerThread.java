package com.multithreading.item8;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProducerThread extends Thread {

    private static final Logger logger = LogManager.getLogger(ProducerThread.class);
    private final ProducerConsumerWrapper dataWrap;
    private final long delay;

    public ProducerThread(ProducerConsumerWrapper dataWrap) {
        this.dataWrap = dataWrap;
        this.delay = dataWrap.getmTime();
    }

    @Override
    public void run() {
        try {
            while (dataWrap.getIsRunning().get()) {
                boolean isConsuming = dataWrap.getIsConsuming().get();
                dataWrap.setIsConsuming(!isConsuming);
                TimeUnit.MILLISECONDS.sleep(delay);
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}
