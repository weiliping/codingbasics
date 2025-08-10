package com.algorithm.contest.weeklycontest433;

import java.util.Arrays;

public class MinMaxSums {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        MinMaxSums m = new MinMaxSums();
        int ans = m.minMaxSums(nums, 2);
        System.out.println(ans);
    }
    private static final int MOD = (int) 1e9 + 7;
    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        long s = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n - i; j++) {
                s += nums[j];
                if (s > MOD) {
                    s -= MOD;
                }
            }
            for (int j = n - 1; j >= i; j--) {
                s += nums[j];
                if (s > MOD) {
                    s -= MOD;
                }
            }
            System.out.println(s + "  " + " i = " + i);
        }        
        return (int) s;    
    }
}
