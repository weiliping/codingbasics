package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class KthSmallestI {

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{1, 5, 12, 2, 11, 5}, 3));
        System.out.println(kthSmallest(new int[]{1, 5, 12, 2, 11, 5}, 4));
        System.out.println(kthSmallest(new int[]{5, 12, 11, -1, 12}, 3));
    }

    public static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
