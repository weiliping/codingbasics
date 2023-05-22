package com.algorithm.contest.weeklycontest203;

import java.util.Arrays;

public class MaxCoins {

    /**
     * https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
     * @param args
     */
    public static void main(String[] args) {
        int[] p = new int[] { 2, 4, 1, 2, 7, 8 };
        System.out.println(maxCoins(p));
        int[] p1 = new int[] { 9,8,7,6,5,1,2,3,4 };
        System.out.println(maxCoins(p1));
        int[] p2 = new int[] { 2,4,5 };
        System.out.println(maxCoins(p2));
    }

    public static int maxCoins(int[] piles) {
        int n = piles.length;
        int res = 0;
        int nums = n / 3;
        Arrays.sort(piles);
        int idx = n - 2;
        for (int i = nums; i > 0; i--) {
            res += piles[idx];
            idx -= 2;
        }
        return res;
    }
}
