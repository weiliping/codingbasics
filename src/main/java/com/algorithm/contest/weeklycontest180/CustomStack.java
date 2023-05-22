package com.algorithm.contest.weeklycontest180;

import java.util.ArrayDeque;

public class CustomStack {
    public static void main(String[] args) {

    }

    int maxSize;
    ArrayDeque<Integer> queue;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        queue = new ArrayDeque<>(maxSize);
    }

    public void push(int x) {
        if (queue.size() < maxSize) {
            queue.offerFirst(x);
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.pollFirst();
    }

    public void increment(int k, int val) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(k);

        while (!queue.isEmpty() && k > 0) {
            stack.push(queue.pollLast() + val);
            k--;
        }

        while (!stack.isEmpty()) {
            queue.offerLast(stack.pop());
        }
    }
}
