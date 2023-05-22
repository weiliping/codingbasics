package com.algorithm.contest.weeklycontest256;

import java.util.Arrays;

public class MinimumDifference {

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[] {9, 4, 1, 7}, 2));
    }

    public static int minimumDifference(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length, ans = nums[k - 1] - nums[0], len = n - k + 1;
        for (int i = 1; i < len; i++) {
            int curr = nums[k + i - 1] - nums[i];
            if (ans > curr) {
                ans = curr;
            }
        }
        return ans;
    }
}
