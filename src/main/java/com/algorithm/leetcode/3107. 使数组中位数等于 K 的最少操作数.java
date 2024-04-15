package com.algorithm.leetcode;

import java.util.Arrays;

class Solution3107 {
    public static void main(String[] args) {
        int[] nums = new int[] {2,5,6,8,5};
        int k = 4;
        Solution3107 s = new Solution3107();
        System.out.println(s.minOperationsToMakeMedianK(nums, k));
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int h = (n >> 1);
        long res = 0l;
        if (nums[h] == k) {
            return res;
        }
        int j = h;
        if (nums[h] < k) {
            while (j < n && nums[j] < k) {
                res += k - nums[j];
                j += 1;
            }
            return res;
        }
        while (j > -1 && nums[j] > k) {
            res += nums[j] - k;
            j -= 1;
        }
        return res; 
    }
}
