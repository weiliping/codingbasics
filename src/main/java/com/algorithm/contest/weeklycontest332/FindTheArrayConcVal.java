package com.algorithm.contest.weeklycontest332;

public class FindTheArrayConcVal {
    public static void main(String[] args) {
        int[] nums = new int[] { 7, 52, 2, 4 };
        FindTheArrayConcVal f = new FindTheArrayConcVal();
        System.out.println(f.findTheArrayConcVal(nums));
        int[] nums1 = new int[] { 5, 14, 13, 8, 12 };
        System.out.println(f.findTheArrayConcVal(nums1));
    }

    public long findTheArrayConcVal(int[] nums) {
        int n = nums.length, h = n / 2;
        long res = 0l;
        for (int i = 0; i < h; i++) {
            int v = nums[n - 1 - i];
            res += nums[i] * getVal(v) + v;
        }
        if (n % 2 != 0) {
            res += nums[h];
        }
        return res;
    }

    private int getVal(int v) {
        if (v < 10) {
            return 10;
        }
        if (v < 100) {
            return 100;
        }
        if (v < 1000) {
            return 1000;
        }
        if (v < 10000) {
            return 10000;
        }
        return 100000;
    }
}
