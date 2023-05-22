package com.multithreaded;

import java.sql.Timestamp;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        System.out.println(new Timestamp(System.currentTimeMillis()));
        for (int i = 0; i < 1000; i++) {
            Runnable worker = new WorkThread(String.valueOf(i));
            executor.execute(worker);
        }
        executor.shutdown();
        System.out.println(new Timestamp(System.currentTimeMillis()));
//        while (!executor.isTerminated()) {
//            System.out.println("executor is not terminated!");
//        }
        System.out.println("all threads are finished.");
    }
}
