package com.multithreading.item7;

public class ExploreYieldApp {
    public static void main(String[] args) {
        CatSoundThread meowWithYieldThread = new CatSoundThread();
        DogSoundThread barkThread = new DogSoundThread();
        meowWithYieldThread.start();
        barkThread.start();
    }
}
