package com.algorithm.arrays;

import java.util.Arrays;

public class NextPermutation {

    /**
     * https://leetcode-cn.com/problems/next-permutation/
     *
     * @param args
     */
    public static void main(String[] args) {
                System.out.println(Arrays.toString(nextPermutation(new int[]{1, 2, 7, 4, 3, 1})));
        //        System.out.println(arrays.toString(nextPermutation(new int[]{3, 2, 1})));
//        System.out.println(Arrays.toString(nextPermutation(new int[] { 1, 5, 1 })));
    }

    public static int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int nextStart = -1;

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                nextStart = i - 1;
                break;
            }
        }

        if (nextStart > -1) {
            for (int j = nums.length - 1; j > 0; j--) {
                if (nums[nextStart] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[nextStart];
                    nums[nextStart] = temp;
                    break;
                }
            }
        }

        int j = nums.length - 1;
        for (int i = nextStart + 1; i < nums.length && i < j; i++) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            j--;
        }
        return nums;
    }
}
