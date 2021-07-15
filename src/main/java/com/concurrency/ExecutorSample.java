package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 15; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
