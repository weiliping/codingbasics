package com.algorithm.backtracking;

import java.util.Arrays;

public class CountArrangement {

    public static void main(String[] args) {
//        System.out.println(countArrangement(3));
        System.out.println(countArrangement(6));
        System.out.println(countArrangement(12));
        System.out.println(countArrangement(13));
        System.out.println(countArrangement(14));
        System.out.println(countArrangement(15));
    }
    public static int countArrangement(int n) {
        int[] nums = new int[n];
        Arrays.setAll(nums, i -> i + 1);
        int[] res = new int[1];
        dfs(nums, 0, res, n);
        return res[0];
    }

    static void dfs(int[] nums, int s, int[] res, int n) {
        if (s == n) {
            res[0]++;
            return;
        }
        for (int i = s; i < n; i++) {
            if (nums[i] % (s + 1) == 0 || (s + 1) % nums[i] == 0) {
                swap(nums, s, i);
                dfs(nums, s + 1, res, n);
                swap(nums, i, s);
            }
        }
    }

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
