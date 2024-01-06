package com.concurrency;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class Reference {
    private final AtomicReference<Integer> tail;

    public Reference(int i) {
        tail = new AtomicReference<Integer>(new Integer(i));
    }

    public void startIt() {
        int j = 55;
        int i = tail.get();
        System.out.println(i + " " + j);
        System.out.println("r=" + tail.getAndSet(j));
    }

    public static void main(String[] args) {
        Executor exec = Executors.newFixedThreadPool(5);
        final Reference f = new Reference(3);
        for (int i = 0; i < 5; i++) {
            exec.execute(f::startIt);
        }
    }
}
