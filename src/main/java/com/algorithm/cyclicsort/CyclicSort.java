package com.algorithm.cyclicsort;

import java.util.Arrays;

public class CyclicSort {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 4, 2};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void cyclicSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
