package com.datastructure;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int k;
    String v;
    LRUNode prev;
    LRUNode next;

    public LRUNode(int key, String val) {
        k = key;
        v = val;
    }
}

public class LRUCache {

    private static int cap;
    private static Map<Integer, LRUNode> holder = new HashMap<>();
    private LRUNode head;
    private LRUNode tail;

    public LRUCache(int capacity) {
        cap = capacity;
    }

    public void put(int k, String v) {
        if (holder.containsKey(k)) {
            LRUNode node = holder.get(k);
            removeNode(node);
            appendToTail(node);
            node.v = v;
            holder.put(k, node);
            return;
        }
        LRUNode node = new LRUNode(k, v);

        if (holder.size() >= cap) {
            holder.remove(head.k);
            removeNode(head);
        }

        appendToTail(node);
        holder.put(k, node);
    }

    public LRUNode get(int k) {
        LRUNode node = holder.get(k);
        if (node != null) {
            removeNode(node);
            appendToTail(node);
        }
        return node;
    }

    private void removeNode(LRUNode node) {
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

    private void appendToTail(LRUNode node) {
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
