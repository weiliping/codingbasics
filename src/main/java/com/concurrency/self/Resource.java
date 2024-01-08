package com.concurrency.self;

public class Resource {
    private volatile int num = 0;
    private volatile int size = 10;

    public synchronized void add() {
        if (num < size) {
            num++;
            System.out.println(Thread.currentThread().getName() + " add num: " + num);
            notifyAll();
        } else {
            try {
                System.out.println("wait maximum resource");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove() {
        if (num > 0) {
            num--;
            System.out.println(Thread.currentThread().getName() + "reduce num: " + num);
            notifyAll();
        } else {
            try {
                wait();
                System.out.println("wait no more resource");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
