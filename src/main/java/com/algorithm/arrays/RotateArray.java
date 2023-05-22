package com.algorithm.arrays;

import java.util.Arrays;

public class RotateArray {

    /**
     * #189
     *
     * https://leetcode-cn.com/problems/rotate-array/
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        if (nums == null || k == 0 || k % nums.length == 0) {
            return;
        }

        int n = nums.length;
        int m = k % n;

        while (m > 0) {
            int tmp = nums[n - 1], i = n - 2;
            while (i >= 0) {
                nums[i + 1] =  nums[i];
                i--;
            }
            nums[0] = tmp;
            m--;
        }
    }
}
