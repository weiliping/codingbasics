package com.algorithm.contest.weeklycontest202;

import java.util.Arrays;

public class MinOperations {
    public static void main(String[] args) {
        array(3);
        array(4);
        array(5);
        array(6);
        array(7);
        array(8);
        array(9);
        System.out.println(minOperations(3));
        System.out.println(minOperations(4));
        System.out.println(minOperations(5));
        System.out.println(minOperations(6));
        System.out.println(minOperations(7));
        System.out.println(minOperations(8));
        System.out.println(minOperations(9));
    }

    public static void array(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = 2 * i + 1;
        }
        System.out.println(Arrays.toString(nums));
    }
    public static int minOperations(int n) {
        int i = n/2;
        boolean isEven = n % 2 == 0;
        int res = 0;
        while (i > 0) {
            res += 2*i;
            if (isEven) {
                res--;
            }
            i--;
        }
        return res;
    }
}
