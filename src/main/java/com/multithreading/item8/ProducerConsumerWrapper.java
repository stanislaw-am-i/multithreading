package com.multithreading.item8;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWrapper {

    private AtomicBoolean isRunning = new AtomicBoolean(true);
    private final AtomicBoolean isConsuming = new AtomicBoolean(false);
    private volatile long leftTime = 5000;
    private long mTime = 500;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public AtomicBoolean getIsRunning() {
        return isRunning;
    }

    public long getLeftTime() {
        return leftTime;
    }

    public void setLeftTime(long leftTime) {
        this.leftTime = leftTime;
    }

    public void decrementLeftTime(long decrement) {
        lock.lock();
        try {
            leftTime -= decrement;
            if (leftTime < 0) {
                leftTime = 0;
                isRunning.set(false);
            }
        } finally {
            lock.unlock();
        }
    }

    public void setIsRunning(AtomicBoolean isRunning) {
        this.isRunning = isRunning;
    }

    public AtomicBoolean getIsConsuming() {
        return isConsuming;
    }

    public void setIsConsuming(boolean value) {
        lock.lock();
        try {
            isConsuming.set(value);
            if (value) {
                condition.signalAll();
            }
        } finally {
            lock.unlock();
        }
    }

    public void checkPermissionToConsume() throws InterruptedException {
        lock.lock();
        try {
            while (!isConsuming.get()) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }

    public long getmTime() {
        return mTime;
    }

    public void setmTime(long mTime) {
        this.mTime = mTime;
    }

}
