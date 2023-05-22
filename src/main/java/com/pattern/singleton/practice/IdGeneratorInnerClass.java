package com.pattern.singleton.practice;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorInnerClass {
    private IdGeneratorInnerClass() {}

    private AtomicLong id = new AtomicLong(0);

    public static IdGeneratorInnerClass getInstance() {
        return IdGeneratorHolder.instance;
    }

    private static class IdGeneratorHolder {
        private static final IdGeneratorInnerClass instance = new IdGeneratorInnerClass();
    }

    public long getId() {
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println(IdGeneratorInnerClass.getInstance().getId());
    }
}
