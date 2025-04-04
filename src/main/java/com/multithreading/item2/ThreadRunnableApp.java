package com.multithreading.item2;

public class ThreadRunnableApp {
    public static void main(String[] args) {
        T1Thread thread = new T1Thread(new T2Runnable());
        thread.start();
    }
}
