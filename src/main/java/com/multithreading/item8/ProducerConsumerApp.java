package com.multithreading.item8;

public class ProducerConsumerApp {

    public static void main(String args[]) {
        ProducerConsumerWrapper wrap = new ProducerConsumerWrapper();
        wrap.setLeftTime(5000);
        wrap.setmTime(500);
        ProducerThread p = new ProducerThread(wrap);
        ConsumerThread c = new ConsumerThread(wrap);

        p.start();
        c.start();
    }
}
