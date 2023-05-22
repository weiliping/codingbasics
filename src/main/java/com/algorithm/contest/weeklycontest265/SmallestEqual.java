package com.algorithm.contest.weeklycontest265;

public class SmallestEqual {
    public int smallestEqual(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
