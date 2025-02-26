package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CLHUseCase {
    private final Lock lock = new CLHLock();
    private int i = 0;

    public void takeout() {
        try {
            lock.lock();
            // System.out.println(Thread.currentThread().getName() + " " + ++i);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final CLHUseCase uCase = new CLHUseCase();
        try {
            ExecutorService exec = Executors.newFixedThreadPool(5);
            for (int i = 1; i <= 5; i++) {
                exec.execute(uCase::takeout);
            }
            exec.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
