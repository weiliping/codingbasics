package com.pattern.singleton.practice;

import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1 = " + IdGenerator.INSTANCE.getId());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("thread2 = " + IdGenerator.INSTANCE.getId());
        });
        thread1.start();
        thread2.start();
//        thread2.start();
    }
}
