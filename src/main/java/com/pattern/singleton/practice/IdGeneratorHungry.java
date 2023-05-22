package com.pattern.singleton.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorHungry {

    private static AtomicLong id = new AtomicLong(0);

    private IdGeneratorHungry() {
    }

    private static final IdGeneratorHungry instance = new IdGeneratorHungry();

    public static IdGeneratorHungry getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }


    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> System.out.println(IdGeneratorHungry.getInstance().getId()));
        }

//        executor.shutdown();
        System.out.println("all threads are finished.");
    }
}
