package com.algorithm.twopointers;

import java.util.Arrays;

public class SquaringArray {
    /**
     * #977
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(squares(new int[] { -7, -3, 2, 3, 11 })));
        System.out.println(Arrays.toString(squares(new int[] { -3, -1, 0, 1, 2 })));
    }

    public static int[] squares(int[] nums) {
        int[] res = new int[nums.length];
        int i = 0, j = nums.length - 1, k = j;
        while (i <= j) {
            int sRes = nums[i] * nums[i], eRes = nums[j] * nums[j];
            if (sRes >= eRes) {
                res[k--] = sRes;
                i++;
            } else {
                res[k--] = eRes;
                j--;
            }
        }
        return res;
    }
}
