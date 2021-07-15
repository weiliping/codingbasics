package com.algorithm.bitmanipulation;

public class SingleNumberII {

    /**
     * #137
     * https://leetcode-cn.com/problems/single-number-ii/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(singleNumberII(new int[] { -2, -2, 1, -4, -2, 3, 3, 5, 3, 5, 5, -4, -4}));
    }

    public static int singleNumberII(int[] nums) {
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; ++i) {
            b = (b ^ nums[i]) & ~a;
            a = (a ^ nums[i]) & ~b;
        }
        return b;
    }
}

