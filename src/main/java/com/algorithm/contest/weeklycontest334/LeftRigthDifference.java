package com.algorithm.contest.weeklycontest334;

import java.util.Arrays;

public class LeftRigthDifference {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(leftRigthDifference(new int[] { 10, 4, 8, 3 })));
    }

    public static int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n + 1], rightSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = Math.abs(leftSum[i] - rightSum[i + 1]);
        }
        return res;
    }
}
