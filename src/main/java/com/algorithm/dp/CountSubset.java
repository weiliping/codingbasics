package com.algorithm.dp;

public class CountSubset {

    public static void main(String[] args) {
//        System.out.println(countSubset(new int[]{1, 1, 2, 3}, 4));
        System.out.println(countSubset(new int[]{1, 2, 7, 1, 5}, 9));
        System.out.println(countSubsetRecursive(new int[]{1, 2, 7, 1, 5}, 9));
//        System.out.println(countSubset(new int[]{10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6}, 30));
    }

    static int countSubsetRecursive(int nums[], int sum) {
        return countRecursiveHelper(nums, sum, 0);
    }

    static int countRecursiveHelper(int[] nums, int sum, int ind) {
        if (sum == 0) {
            return 1;
        }
        if (ind >= nums.length) {
            return 0;
        }

        int l = 0;
        if (nums[ind] <= sum) {
            l = countRecursiveHelper(nums, sum - nums[ind], ind + 1);
        }
        int r = countRecursiveHelper(nums, sum, ind + 1);
        return l + r;
    }

    public static int countSubset(int[] nums, int sum) {
        int n = nums.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[sum];
    }
}
