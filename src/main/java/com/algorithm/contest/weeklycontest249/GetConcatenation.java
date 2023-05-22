package com.algorithm.contest.weeklycontest249;

import java.util.Arrays;

public class GetConcatenation {

    public static void main(String[] args) {
        GetConcatenation g = new GetConcatenation();
        System.out.println(Arrays.toString(g.getConcatenationI(new int[] { 1, 2, 1 })));
        System.out.println(Arrays.toString(g.getConcatenation(new int[] { 1, 2, 1 })));
    }

    public int[] getConcatenationI(int[] nums) {
        int n = nums.length, ans[] = new int[2 * n];
        System.arraycopy(nums, 0, ans, 0, n);
        System.arraycopy(nums, 0, ans, n, n);
        return ans;
    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = ans[i];
        }

        return ans;
    }
}
