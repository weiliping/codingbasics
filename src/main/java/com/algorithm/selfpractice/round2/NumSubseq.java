package com.algorithm.selfpractice.round2;

import java.util.Arrays;

public class NumSubseq {

    public static void main(String[] args) {
//        System.out.println(2 << );
//        long[] memo = new long[6];
//        System.out.println(pow(5, memo));
//        System.out.println(Arrays.toString(memo));
//        System.out.println(Arrays.toString(nums()));
        System.out.println(new NumSubseq().numSubseq(new int[] { 27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22 }, 31));
    }
    public int numSubseqII(int[] nums, int target) {
        int n = nums.length;
        long[] p = new long[n + 1];
        Arrays.fill(p, 1);
        for (int i = 1; i <= n; i++) {
            p[i] = (p[i - 1] << 1) % 1000000007;
        }
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0, j = n - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target) --j;
            if (i > j) {
                continue;
            }
            System.out.println("p[j - i] =" + p[j - i]);
            res = (res + p[j - i]) % 1000000007;
        }
        return (int) res;
    }

    static long[] nums(){
        long[] nums = new long[6];
        nums[0] = 1;
        for (int i = 1; i <= 5; ++i) {
            nums[i] = (nums[i - 1] << 1) % 1000000007;
        }
        return nums;
    }

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        long[] memo = new long[n];
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0, j = n - 1; i <= j; ++i) {
            while (i <= j && nums[i] + nums[j] > target) --j;
            if (i > j) {
                continue;
            }
            res = (res + pow(j - i, memo)) % 1000000007;
        }
        return (int) res;
    }

    static long pow(int time, long[] memo) {
        if (time == 0) {
            memo[time] = 1;
        }
        if (memo[time] > 0) {
            return memo[time];
        }
        memo[time] = (pow(time - 1, memo) * 2) % 1000000007;
        return memo[time];
    }
}
