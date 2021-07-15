package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class SumOfElements {

    public static void main(String[] args) {
        System.out.println(sumElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6));
        System.out.println(sumElements(new int[] { 3, 5, 8, 7 }, 1, 4));
    }

    public static int sumElements(int[] nums, int k1, int k2) {
        int sum = 0, n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        for (int num : nums) {
            queue.offer(num);
        }

        for (int j = 0; j < n; j++) {
            int num = queue.poll();
            if (j > k1 - 1 && j < k2 - 1) {
                sum += num;
            }
        }
        return sum;
    }
}
