package com.algorithm.selfpractice.round2;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));
    }

    int cap;
    public LinkedNode head;
    public LinkedNode tail;
    HashMap<Integer, LinkedNode> hash = new HashMap<>();
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int cap) {
        this.cap = cap;
    }

    public int get(int key) {
        try {
            lock.readLock().lock();
            if (hash.containsKey(key)) {
                LinkedNode node = hash.get(key);
                remove(node);
                offer(node);
                return node.val;
            }
        } finally {
            lock.readLock().unlock();
        }
        return -1;
    }

    public void put(int key, int val) {
        try {
            lock.writeLock().lock();
            if (hash.containsKey(key)) {
                LinkedNode node = hash.get(key);
                node.val = val;
                remove(node);
                offer(node);
                return;
            }
            if (hash.size() >= cap) {
                hash.remove(head.key);
                remove(head);
            }
            LinkedNode node = new LinkedNode(key, val);
            hash.put(key, node);
            offer(node);
        } finally {
            lock.writeLock().unlock();
        }
    }

    private void remove(LinkedNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void offer(LinkedNode node) {
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        node.next = null;
        tail = node;

        if (head == null) {
            head = tail;
        }
    }
}
