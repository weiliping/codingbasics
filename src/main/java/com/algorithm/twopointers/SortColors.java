package com.algorithm.twopointers;

import java.util.Arrays;

public class SortColors {

    /**
     * #75
     * https://leetcode-cn.com/problems/sort-colors/
     * @param args
     */
    public static void main(String[] args) {
        new SortColors().sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
    }

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] colors = new int[3];

        for (int n : nums) {
            colors[n]++;
        }

        int curr = 0;
        for (int i = 0; i < colors.length; i++) {
            while (colors[i] > 0) {
                nums[curr] = i;
                colors[i]--;
                curr++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
