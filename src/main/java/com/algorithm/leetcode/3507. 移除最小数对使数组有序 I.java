package com.algorithm.leetcode;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean isValid = true;
            for (int k = 0; k < n - i - 2; k++) {
                if (nums[k] > nums[k + 1]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                break;
            }

            int minI = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] + nums[j + 1] < min) {
                    min = nums[j] + nums[j + 1];
                    minI = j;
                }
            }
            if (minI == -1) {
                break;
            }
            nums[minI] = min;
            res++;
            for (int k = minI + 1; k < n - i - 1; k++) {
                nums[k] = nums[k + 1];
            }
        }
        return res;
    }
}
