package com.algorithm.selfpractice;

import java.util.HashMap;
import java.util.Map;

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
    private static Map<Integer, CacheNode> holder = new HashMap<>();
    private CacheNode head;
    private CacheNode tail;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public void put(int k, String v) {
        if (!holder.containsKey(k)) {
            if (holder.size() >= cap) {
                holder.remove(head.k);
                removeNode(head);
            }
            CacheNode node = new CacheNode(k, v);
            appendToTail(node);
            holder.put(k, node);
        }

        CacheNode node = holder.get(k);
        node.v = v;
        removeNode(node);
        appendToTail(node);
        holder.put(k, node);
    }

    public CacheNode get(int k) {
        CacheNode node = holder.get(k);
        if (node != null) {
            removeNode(node);
            appendToTail(node);
        }
        return node;
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
