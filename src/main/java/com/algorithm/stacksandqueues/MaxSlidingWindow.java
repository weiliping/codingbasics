package com.algorithm.stacksandqueues;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    /**
     * #239
     * https://leetcode-cn.com/problems/sliding-window-maximum/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 2, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (deque.size() > 0 && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i - k + 1 >= 0) {
                res[i - k + 1] = nums[deque.getFirst()];
            }

            if (i - k + 1 >= deque.getFirst()) {
                deque.removeFirst();
            }
        }
        return res;
    }
}
