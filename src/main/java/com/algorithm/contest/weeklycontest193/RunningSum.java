package com.algorithm.contest.weeklycontest193;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        RunningSum r = new RunningSum();
        System.out.println(Arrays.toString(r.runningSum(new int[] { 1, 2, 3, 4 })));
    }
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }
}
