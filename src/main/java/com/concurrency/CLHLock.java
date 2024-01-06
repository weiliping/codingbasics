package com.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock implements Lock {

    private final AtomicReference<QNode> tail;

    private final ThreadLocal<QNode> myPrev;

    private final ThreadLocal<QNode> myNode;

    public CLHLock() {
        this.tail = new AtomicReference<>(new QNode("PREV"));
        this.myPrev = new ThreadLocal<QNode>();
        this.myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode("CURR");
            }
        };
    }

    @Override
    public void lock() {
        System.out.println("Thread Name acquired a lock. thread name: " + Thread.currentThread().getName());
        QNode node = myNode.get();
        node.locked = true;
        System.out.println("currNode name: " + node.getName() + " thread name: " + Thread.currentThread().getName());
        QNode prevNode = tail.getAndSet(node);

        myPrev.set(prevNode);
        System.out.println("tail list: " + tail.toString());
        System.out
                .println("prevNode name: " + prevNode.getName() + " thread name: " + Thread.currentThread().getName());
        while (prevNode.locked) {
        }
        System.out.println("Thread name executed " + Thread.currentThread().getName());
    }

    @Override
    public void unlock() {
        QNode currNode = myNode.get();
        System.out.println(
                "unlock currNode name: " + currNode.getName() + " thread name: " + Thread.currentThread().getName());
        currNode.locked = false;
        QNode prevNode = myPrev.get();
        System.out.println(
                "unlock prevNode name: " + prevNode.getName() + " thread name: " + Thread.currentThread().getName());
        myNode.set(myPrev.get());
        System.out.println("Thread name release lock " + Thread.currentThread().getName());
    }
}
