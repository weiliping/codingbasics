package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class KthSmallest {
    /**
     * #378
     * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        System.out.println(kthSmallest(matrix, 8));
        int[][] matrix2 = new int[][] { { -5 } };
        System.out.println(kthSmallest(matrix2, 1));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);

        for (int[] nums : matrix) {
            for (int num : nums) {
                if (queue.size() < k) {
                    queue.offer(num);
                    continue;
                }
                if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        return queue.peek();
    }
}
