package com.algorithm.contest.weeklycontest181;

import java.util.ArrayDeque;

public class CustomStack {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                          // 栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        System.out.println(customStack.pop());                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        customStack.push(2);                          // 栈变为 [1, 2]
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        System.out.println(customStack.pop());                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        System.out.println(customStack.pop());                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        System.out.println(customStack.pop());                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        System.out.println(customStack.pop());
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
