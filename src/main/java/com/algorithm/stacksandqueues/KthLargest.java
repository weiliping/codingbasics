package com.algorithm.stacksandqueues;

import java.util.PriorityQueue;

public class KthLargest {
    /**
     * #703
     * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
     * @param args
     */
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }

    PriorityQueue<Integer> queue;
    int s;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        s = k;
        for (int i = 0; i < nums.length; i++) {
            addNum(nums[i]);
        }
    }

    private void addNum(int val) {
        if (queue.size() < s) {
            queue.offer(val);
            return;
        }
        if (val > queue.peek()) {
            queue.poll();
            queue.offer(val);
        }
    }
    public int add(int val) {
        addNum(val);
        return queue.peek();
    }
}
