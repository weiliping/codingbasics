package com.concurrency.self;

public class Resource {
    private volatile int num = 0;
    private volatile int size = 10;

    public synchronized void add() {
        if (num < size) {
            num++;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove() {
        if (num > 0) {
            num--;
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
