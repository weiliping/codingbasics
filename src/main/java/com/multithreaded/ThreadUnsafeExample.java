package com.multithreaded;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadUnsafeExample {
    private int cnt = 0;
    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void add() {
        try {
            lock.writeLock().lock();
            cnt += 2;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int get() {
        try {
            lock.readLock().lock();
            return cnt;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }
}
