package com.algorithm.twopointers;

import java.util.Arrays;

public class TripletSumCloseToTarget {
    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Triplet%20Sum%20Close%20to%20Target%20(medium).py
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(tripletSumCloseToTarget(new int[] { -2, 0, 1, 2 }, 2));
        System.out.println(tripletSumCloseToTarget(new int[] { -3, -1, 1, 2 }, 1));
        System.out.println(tripletSumCloseToTarget(new int[] { 1, 0, 1, 1 }, 100));
    }

    public static int tripletSumCloseToTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int closeTarget = Integer.MIN_VALUE, min = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
                int tmp_min = Math.abs(tmp - target);
                if (min > tmp_min) {
                    closeTarget = tmp;
                    min = tmp_min;
                }

                if (nums[i] + nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closeTarget;
    }
}
