package com.algorithm.contest.weeklycontest263;

public class CountMaxOrSubsets {
    public static void main(String[] args) {
        System.out.println(countMaxOrSubsets(new int[] {3, 2, 1, 5}));
        System.out.println(countMaxOrSubsets(new int[] {3, 1}));
        System.out.println(countMaxOrSubsets(new int[] {2, 2, 2}));
    }

    public static int countMaxOrSubsets(int[] nums) {
        int max = nums[0], n = nums.length;
        for (int i = 1; i < n; i++) {
            max |= nums[i];
        }
        int[] res = new int[1];
        dfs(nums, res, max, 0, 0, n);
        return res[0];
    }

    static void dfs(int[] nums, int[] res, int max, int curr, int s, int n) {
        if (curr == max) {
            res[0] += 1 << (n - s);
            return;
        }

        if (s == n) {
            return;
        }
        dfs(nums, res, max, curr | nums[s], s + 1, n);
        dfs(nums, res, max, curr, s + 1, n);
    }
}
