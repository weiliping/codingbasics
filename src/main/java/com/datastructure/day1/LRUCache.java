package com.datastructure.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class CacheNode {
    int k;
    String v;
    CacheNode prev;
    CacheNode next;
    public CacheNode(int key, String val) {
        k = key;
        v = val;
    }
}

public class LRUCache {
    private static int cap;
    private static Map<Integer, CacheNode> holder;
    private CacheNode head;
    private CacheNode tail;
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public LRUCache(int capacity) {
        cap = capacity;
        holder = new HashMap<>();
    }

    public void put(int k, String val) {
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            CacheNode node = holder.get(k);
            if (node == null) {
                if (holder.size() >= cap) {
                    holder.remove(head.k);
                    removeNode(head);
                }
                node = new CacheNode(k, val);
                appendToTail(node);
                holder.put(k, node);
                return;
            }
            node.v = val;
            removeNode(node);
            appendToTail(node);
            holder.put(k, node);
        } finally {
            writeLock.unlock();
        }
    }

    public CacheNode get(int k) {
        ReentrantReadWriteLock.ReadLock rLock = lock.readLock();
        rLock.lock();
        try {
            if (holder.containsKey(k)) {
                CacheNode node = holder.get(k);
                removeNode(node);
                appendToTail(node);
                return node;
            }
            return null;
        } finally {
            rLock.unlock();
        }
    }

    private void removeNode(CacheNode node) {
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

    private void appendToTail(CacheNode node) {
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
