package com.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class CLHLock implements Lock {

    private final AtomicReference<QNode> tail;

    private final ThreadLocal<QNode> myPrev;

    private final ThreadLocal<QNode> myNode;

    public CLHLock() {
        this.tail = new AtomicReference<>(new QNode("PREV", false));
        this.myPrev = new ThreadLocal<QNode>();
        this.myNode = new ThreadLocal<QNode>() {
            protected QNode initialValue() {
                return new QNode("CURR", false);
            }
        };
    }

    @Override
    public void lock() {
        QNode node = myNode.get();
        node.locked = true;
        QNode prevNode = tail.getAndSet(node);
        myPrev.set(prevNode);
        while (prevNode.locked) {
        }
        System.out.println("Thread name executed " + Thread.currentThread().getName());
    }

    @Override
    public void unlock() {
        QNode currNode = myNode.get();
        currNode.locked = false;
        System.out.println("unlock thread name: " + Thread.currentThread().getName() + " prevNode name: "
                + myPrev.get().getName() + " currNode name: " + currNode.getName());
        myNode.set(myPrev.get());
    }
}
