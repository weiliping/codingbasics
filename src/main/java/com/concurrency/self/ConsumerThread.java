package com.concurrency.self;

public class ConsumerThread implements Runnable {

    private Resource res;

    public ConsumerThread(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.remove();
    }
}
