package com.algorithm.bitmanipulation;

import java.util.Arrays;

public class SingleNumberIII {
    /**
     * #260
     * https://leetcode-cn.com/problems/single-number-iii/
     * @param args
     */
    public static void main(String[] args) {

        int[] nums = new int[] {2, 1, 3, 2};
        System.out.println(Arrays.toString(singleNumberIII(nums)));

        int[] nums1 = new int[] {1, 4, 2, 1, 3, 5, 6, 2, 3, 5};
        System.out.println(Arrays.toString(singleNumberIII(nums1)));
    }

    public static int[] singleNumberIII(int[] nums) {
        int xorNums = 0;
        for (int num : nums) {
            xorNums ^= num;
        }

        int rightBitDiff = 1;
        while ((rightBitDiff & xorNums) == 0) {
            rightBitDiff = rightBitDiff << 1;
        }

        int res[] = new int[2];
        for (int num : nums) {
            if ((num & rightBitDiff) != 0) {
                res[1] ^= num;
            } else {
                res[0] ^= num;
            }
        }
        return res;
    }
}
