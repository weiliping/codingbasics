package com.algorithm.contest.weeklycontest183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence {
    public static void main(String[] args) {

        MinSubsequence m = new MinSubsequence();
        System.out.println(Arrays.toString(m.minSubsequence(new int[] { 4, 3, 10, 9, 8 }).toArray()));
        System.out.println(Arrays.toString(m.minSubsequence(new int[] { 4, 4, 7, 6, 7 }).toArray()));
        System.out.println(Arrays.toString(m.minSubsequence(new int[] { 6 }).toArray()));
    }

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int r = sums[n] - sums[i];
            int l = sums[i] - sums[0];
            res.add(nums[i]);
            if (r > l) {
                return res;
            }
        }
        return res;
    }
}
