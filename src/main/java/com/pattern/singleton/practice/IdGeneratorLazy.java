package com.pattern.singleton.practice;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorLazy {

    private IdGeneratorLazy() {
    }

    private AtomicLong id = new AtomicLong(0);
    private static IdGeneratorLazy instance;

    public static synchronized IdGeneratorLazy getInstance() {
        if (instance == null) {
            instance = new IdGeneratorLazy();
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorLazy.getInstance().getId());
    }
}
