package com.concurrency.self;

public class ProducerThread implements Runnable {
    private Resource res;

    public ProducerThread(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        res.add();
    }
}
