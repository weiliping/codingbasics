package com.algorithm.contest.biweeklycontest50;

public class MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            int t = nums[i] + 1;
            cnt += t - nums[i + 1];
            nums[i + 1] = t;
        }
        return cnt;
    }
}
