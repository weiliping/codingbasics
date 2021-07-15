package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample extends Thread{
    public void func1() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedExample sync = new SynchronizedExample();
        ExecutorService es = Executors.newCachedThreadPool();
        es.execute(sync::func1);
        es.execute(sync::func1);
    }
}


