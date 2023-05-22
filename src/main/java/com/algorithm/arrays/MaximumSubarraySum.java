package com.algorithm.arrays;

public class MaximumSubarraySum {

    /**
     * #53
     * https://leetcode-cn.com/problems/maximum-subarray
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        MaximumSubarraySum subarraySum = new MaximumSubarraySum();
        System.out.println(subarraySum.largestSubarraySum(nums));
    }

    public int largestSubarraySum(int[] nums) {
        int maxSum = nums[0], subarraySum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            subarraySum = Math.max(nums[i], subarraySum + nums[i]);
            maxSum = Math.max(maxSum, subarraySum);
        }
        return maxSum;
    }
}
