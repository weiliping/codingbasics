package com.pattern.observer;

public class ProducerConsumerWithWaitNofity {
    public static void main(String[] args) {
        Resource res = new Resource(10);
        Producer p1 = new Producer(res);
        Producer p2 = new Producer(res);
        Consumer c0 = new Consumer(res);
        Consumer c1 = new Consumer(res);
        p1.start();
        p2.start();
        c0.start();
        c1.start();
    }
}

class Producer extends Thread {
    private Resource res;

    public Producer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.res.add();
        }
    }
}

class Consumer extends Thread {
    private Resource res;

    public Consumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.res.take();
        }
    }
}

class Resource {
    private int num;
    private int size;

    public Resource(int size) {
        this.size = size;
    }

    public synchronized void add() {
        if (num < size) {
            num++;
            System.out.println("Producer thread name: " + Thread.currentThread().getName());
            notifyAll();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void take() {
        if (num > 0) {
            num--;
            System.out.println("Consumer thread name: " + Thread.currentThread().getName());
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
