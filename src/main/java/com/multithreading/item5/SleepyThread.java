package com.multithreading.item5;

public class SleepyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            throw new RuntimeException("Somebody is trying to wake up sleepy thread.");
        }
    }
}
