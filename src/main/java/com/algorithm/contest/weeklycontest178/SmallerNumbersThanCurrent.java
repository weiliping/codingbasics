package com.algorithm.contest.weeklycontest178;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        SmallerNumbersThanCurrent s = new SmallerNumbersThanCurrent();
        System.out.println(Arrays.toString(s.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 })));
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int[] qu = new int[n];
        for (int i = 0; i < n; i++) {
            int res = 0, j = nums[i];
            while (j > 0) {
                res += cnt[--j];
            }
            qu[i] = res;
        }
        return qu;
    }
}
