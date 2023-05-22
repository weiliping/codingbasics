package com.algorithm.contest.weeklycontest241;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int nums[] = new int[] {1, 2, 3, 4, 5};
        new Test().helper(0, nums, 3);
    }
    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void helper(int start, int[] nums, int k) {
        if (start == nums.length - 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            helper(start + 1, nums, k);
            swap(nums, i, start);
        }
    }
}
