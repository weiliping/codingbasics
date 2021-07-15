package com.algorithm.selfpractice.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 0, 9, 1, 8, 4, 6, 7, 2 };
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int j, tmp = nums[i];
            for (j = i - 1; j >= 0 && tmp < nums[j]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
    }
}
