package com.algorithm.twopointers;

import java.util.Arrays;

public class DutchFlagSort {
    /**
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Dutch%20National%20Flag%20Problem%20(medium).py
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, 2, 1, 0 };
        sortColor(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColor(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                int tmp = nums[l];
                nums[l] = nums[i];
                nums[i] = tmp;
                l++;
                i++;
                continue;
            }
            if (nums[i] == 2) {
                int tmp = nums[r];
                nums[r] = nums[i];
                nums[i] = tmp;
                r--;
                continue;
            }
            i++;
        }
    }
}
