package com.pattern.observer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObserverBlockingQueue {

    public static void main(String[] args) {
        BlockingQueueResource res = new BlockingQueueResource();
        ProducerBlocking p = new ProducerBlocking(res);
        ConsumerBlocking c = new ConsumerBlocking(res);
        ConsumerBlocking c2 = new ConsumerBlocking(res);
        ConsumerBlocking c1 = new ConsumerBlocking(res);
        new Thread(p).start();
        new Thread(c).start();
        new Thread(c1).start();
        new Thread(c2).start();
    }
}

class ProducerBlocking implements Runnable {
    private BlockingQueueResource res;

    public ProducerBlocking(BlockingQueueResource resource) {
        this.res = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.add();
        }
    }
}

class ConsumerBlocking implements Runnable {
    private BlockingQueueResource res;

    public ConsumerBlocking(BlockingQueueResource source) {
        this.res = source;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            res.take();
        }
    }
}

class BlockingQueueResource {
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);

    // private BlockingQueue resourceQueue = new LinkedBlockingQueue(10);
    public void add() {
        try {
            queue.put("message");
            System.out.println("put size: " + queue.size() + " Thread Name: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take() {
        try {
            String s = queue.take();
            System.out.println(
                    "take size: " + queue.size() + " Thread Name: " + Thread.currentThread().getName() + " msg: " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
