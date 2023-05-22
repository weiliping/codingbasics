package com.datastructure.day2;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Stack<Integer> stack = new Stack<>();
        // System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3,
        // 2, 3, 6, 7 }, 3)));
        // System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
        // System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 },
        // 1)));
        // int[] nums = new int[] {5, 3, 8, 7, 9};
        // Deque<Integer> indices = new LinkedList<>();
        // for (int num : nums) {
        // indices.addLast(num);
        // }
        // System.out.println("addd");
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0)
            return nums;

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> indices = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            while (indices.size() > 0 && nums[i] >= nums[indices.getLast()]) {
                indices.removeLast();
            }

            indices.addLast(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[indices.getFirst()];
            }

            if (i - k + 1 >= indices.getFirst()) {
                indices.removeFirst();
            }
        }

        return ans;
    }

    public static int[] maxSlidingWindowII(int nums[], int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i < n - k + 1; i++) {
            res[i] = getMax(i, i + k - 1, nums);
        }
        return res;
    }

    static int getMax(int s, int e, int[] nums) {
        int res = nums[s];
        for (int i = s + 1; i <= e; i++) {
            if (res < nums[i]) {
                res = nums[i];
            }
        }
        return res;
    }
}
