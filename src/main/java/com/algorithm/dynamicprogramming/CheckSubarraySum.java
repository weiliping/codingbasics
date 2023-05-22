package com.algorithm.dynamicprogramming;

public class CheckSubarraySum {

    /**
     * #523
     * https://leetcode-cn.com/problems/continuous-subarray-sum/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6));
        System.out.println(checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
