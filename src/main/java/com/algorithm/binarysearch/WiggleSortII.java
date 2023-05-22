package com.algorithm.binarysearch;

import java.util.Arrays;

public class WiggleSortII {

    /**
     * #324
     * https://leetcode-cn.com/problems/wiggle-sort-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 4, 5, 1, 1, 7 };
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(tmp);
        int n = nums.length, j = (n + 1) / 2, k = n;
        for (int i = 0; i < n; i++) {
            nums[i] = (i & 1) == 0 ? tmp[--j] : tmp[--k];
        }
    }
}
