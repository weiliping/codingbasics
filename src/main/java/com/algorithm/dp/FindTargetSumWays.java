package com.algorithm.dp;

public class FindTargetSumWays {

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public static int findTargetSumWays(int nums[], int S) {
        return helperSumWays(nums, 0, S);
    }

    public static int helperSumWays(int nums[], int ind, int sum) {
        if (ind == nums.length) {
            return sum == 0 ? 1 : 0;
        }
        int left = helperSumWays(nums, ind + 1, sum - nums[ind]);
        int right = helperSumWays(nums, ind + 1, sum + nums[ind]);
        return left + right;
    }
}
