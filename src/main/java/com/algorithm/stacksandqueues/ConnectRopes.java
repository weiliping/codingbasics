package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static void main(String[] args) {
        System.out.println(connectRepes(new int[] {1, 3, 11, 5}));
        System.out.println(connectRepes(new int[] {3, 4, 5, 6}));
        System.out.println(connectRepes(new int[] {1, 3, 11, 5, 2}));
    }

    public static int connectRepes(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            queue.offer(num);
        }

        int sum = 0;
        while (!queue.isEmpty() && queue.size() >= 2) {
            int subSum = queue.poll() + queue.poll();
            sum += subSum;
            queue.offer(subSum);
        }
        return sum;
    }
}
