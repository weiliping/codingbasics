package com.algorithm.contest.weeklycontest296;

import java.util.Arrays;

public class ArrayChange {

    public static void main(String[] args) {
        // int[] nums = new int[] { 1, 2, 4, 6 };
        // int[][] operations = new int[][] { { 1, 3 }, { 4, 7 }, { 6, 1 } };
        // System.out.println(Arrays.toString(arrayChange(nums, operations)));
        // int[] nums1 = new int[] { 1 };
        // int[][] operations1 = new int[][] { { 1, 2 }, { 2, 3 }, { 3, 1000000 }, {
        // 1000000, 1 } };
        // System.out.println(Arrays.toString(arrayChange(nums1, operations1)));

        int[] nums2 = new int[] { 1000000 };
        int[][] operations2 = new int[][] { { 1000000, 999999 }, { 999999, 999998 }, { 999998, 999997 },
                { 999997, 999990 } };
        System.out.println(Arrays.toString(arrayChange(nums2, operations2)));
    }

    public static int[] arrayChange(int[] nums, int[][] operations) {
        int[] inds = new int[1000001];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            inds[nums[i]] = i;
        }

        for (int[] op : operations) {
            int i = inds[op[0]];
            inds[op[1]] = i;
            nums[i] = op[1];
        }
        return nums;
    }
}
