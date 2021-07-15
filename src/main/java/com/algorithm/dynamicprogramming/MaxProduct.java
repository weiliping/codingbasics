package com.algorithm.dynamicprogramming;

public class MaxProduct {

    /**
     * #152
     * https://leetcode-cn.com/problems/maximum-product-subarray/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 0, 2 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] maxp = new int[n], minp = new int[n];
        int res = nums[0];
        maxp[0] = nums[0];
        minp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            maxp[i] = Math.max(Math.max(minp[i - 1] * nums[i], nums[i]), maxp[i - 1] * nums[i]);
            minp[i] = Math.min(Math.min(minp[i - 1] * nums[i], nums[i]), maxp[i - 1] * nums[i]);
            res = Math.max(maxp[i], res);
        }
        return res;
    }
}
