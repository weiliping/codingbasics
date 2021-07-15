package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class FindKthLargest {
    /**
     * #215
     * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int i : nums) {
            queue.offer(i);
        }
        while (k > 1) {
            queue.poll();
            k--;
        }
        return queue.poll();
    }
}
