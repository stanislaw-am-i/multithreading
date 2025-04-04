package com.multithreading.item4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunThreadWithParamApp {
    private static final Logger logger = LogManager.getLogger(RunThreadWithParamApp.class);
    public static void main(String[] args) {
        List<List<String>> differentStrings = new ArrayList<>();
        differentStrings.add(Stream.of("Lorem", "ipsum", "dolor", "sit", "amet", "consectetur").collect(Collectors.toList()));
        differentStrings.add(Stream.of("adipiscing", "elit", "sed", "do", "eiusmod", "tempor").collect(Collectors.toList()));
        differentStrings.add(Stream.of("incididunt", "ut", "labore", "et", "dolore", "magna", "aliqua").collect(Collectors.toList()));
        differentStrings.add(Stream.of("Ut", "enim", "ad", "minim", "veniam").collect(Collectors.toList()));

        for (List<String> string : differentStrings) {
            PrintStringSequenceThread printThread = new PrintStringSequenceThread(string);
            printThread.start();
            try {
                printThread.join();
            } catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
