package com.multithreading.item8;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConsumerThread extends Thread {

    private static final Logger logger = LogManager.getLogger(ConsumerThread.class);
    private final ProducerConsumerWrapper dataWrap;
    private final long delay;

    public ConsumerThread(ProducerConsumerWrapper dataWrap) {
        this.dataWrap = dataWrap;
        this.delay = dataWrap.getmTime() / 10;
    }

    @Override
    public void run() {
        try {
            while (dataWrap.getIsRunning().get()) {
                long latency = 0;
                if (!dataWrap.getIsConsuming().get()) {
                    dataWrap.checkPermissionToConsume();
                    latency = 500;
                }

                if (dataWrap.getIsConsuming().get()) {
                    long currentTime = dataWrap.getLeftTime();
                    logger.info("Left time: {} ms", currentTime);

                    dataWrap.decrementLeftTime(delay + latency);
                    TimeUnit.MILLISECONDS.sleep(delay);
                }
            }
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

}
