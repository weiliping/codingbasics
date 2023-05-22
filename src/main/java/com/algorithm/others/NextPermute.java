package com.algorithm.others;

import java.util.Arrays;

public class NextPermute {

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 6, 4, 2 };
        System.out.println(Arrays.toString(nextPermute(nums)));
    }

    public static int[] nextPermute(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int sIndex = -1, l = nums.length;
        for (int j = l - 1; j > 0; j--) {
            if (nums[j] > nums[j - 1]) {
                sIndex = j - 1;
                break;
            }
        }

        if (sIndex > -1) {
            for (int j = l - 1; j > sIndex; j--) {
                if (nums[sIndex] < nums[j]) {
                    swap(nums, sIndex, j);
                    break;
                }
            }
        }

        int start = sIndex + 1;
        for (int j = l - 1; j > start; j--) {
            swap(nums, start, j);
            start++;
        }
        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
