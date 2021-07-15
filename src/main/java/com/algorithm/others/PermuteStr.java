package com.algorithm.others;

import java.util.Arrays;

public class PermuteStr {

    public static void main(String[] args) {
        permute(new int[] { 1, 2, 3, 5 }, 0, 4);
    }

    public static void permute(int[] nums, int s, int l) {
        if (s == l - 1) {
            System.out.println(Arrays.toString(nums));
        }

        for (int j = s; j < l; j++) {
            swap(nums, s, j);
            permute(nums, s + 1, l);
            swap(nums, j, s);
        }
    }

    public static int[] swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return nums;
    }
}
