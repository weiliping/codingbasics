package com.pattern.singleton.practice;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorDoubleCheck {

    private IdGeneratorDoubleCheck() {}

    private AtomicLong id = new AtomicLong(0);

    private static volatile IdGeneratorDoubleCheck instance;

    public static IdGeneratorDoubleCheck getInstance() {
        if (instance == null) {
            synchronized (IdGeneratorDoubleCheck.class) {
                if (instance == null) {
                    instance = new IdGeneratorDoubleCheck();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorDoubleCheck.getInstance().getId());
    }
}
