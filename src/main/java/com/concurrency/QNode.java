package com.concurrency;

public class QNode {
    volatile boolean locked;

    volatile int id;

    volatile String name;

    public QNode(int id) {
        this.id = id;
    }

    public QNode(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}