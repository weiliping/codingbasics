package com.pattern.observer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockCondition {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition producerCond = lock.newCondition();
        Condition consumerCond = lock.newCondition();
        ResourceLockCondition res = new ResourceLockCondition(10, lock, producerCond, consumerCond);
        ProducerThread p1 = new ProducerThread(res);
        ProducerThread p2 = new ProducerThread(res);
        ConsumerThread c1 = new ConsumerThread(res);
        ConsumerThread c2 = new ConsumerThread(res);
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}

class ProducerThread extends Thread {
    private ResourceLockCondition res;

    public ProducerThread(ResourceLockCondition res) {
        this.res = res;
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

class ConsumerThread extends Thread {
    private ResourceLockCondition res;

    public ConsumerThread(ResourceLockCondition res) {
        this.res = res;
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

class ResourceLockCondition {
    private int num;
    private int size;

    private ReentrantLock lock;
    private Condition producerCond;
    private Condition consumerCond;

    public ResourceLockCondition(int size, ReentrantLock lock, Condition producerCond, Condition consumerCond) {
        this.size = size;
        this.lock = lock;
        this.producerCond = producerCond;
        this.consumerCond = consumerCond;
    }

    public void add() {
        try {
            lock.lock();
            if (num < size) {
                num++;
                System.out.println("Producer thread name: " + Thread.currentThread().getName());
                consumerCond.signalAll();
            } else {
                try {
                    producerCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void take() {
        try {
            lock.lock();
            if (num > 0) {
                num--;
                System.out.println("Consumer thread name: " + Thread.currentThread().getName());
                producerCond.signalAll();
            } else {
                try {
                    consumerCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}
