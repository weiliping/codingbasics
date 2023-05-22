package com.algorithm.contest.weeklycontest241;

public class SubsetXORSum {
    public static void main(String[] args) {
        SubsetXORSum s = new SubsetXORSum();
        System.out.println(s.subsetXORSum(new int[]{1, 3}));
        System.out.println(s.subsetXORSum(new int[]{5,1,6}));
        System.out.println(s.subsetXORSum(new int[]{3,4,5,6,7,8}));
        System.out.println(s.subsetXORSum(new int[]{1, 1, 1}));
    }
    public int subsetXORSum(int[] nums) {
        int[] res = new int[1];
        dfs(nums, 0, nums.length, res, 0);
        return res[0];
    }

    static void dfs(int[] nums, int s, int l, int[] res, int out) {
        for (int j = s; j < l; j++) {
            out ^= nums[j];
            res[0] += out;
            dfs(nums, j + 1, l, res, out);
            out ^= nums[j];
        }
    }
}
