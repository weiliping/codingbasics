package com.algorithm.twopointers;

import java.util.Arrays;
import java.util.LinkedList;

public class DequeTest {

    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addLast(4);
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollFirst();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollFirst();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollFirst();
        System.out.println(Arrays.toString(deque.toArray()));
        deque.pollLast();
        System.out.println(Arrays.toString(deque.toArray()));
    }
}
