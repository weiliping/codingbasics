package com.algorithm.leetcode;

import java.util.Arrays;

class SolutionI {
    public static void main(String[] args) {
        SolutionI s = new SolutionI();
        s.sumOfPowers(new int[] {1, 3, 5, 2}, 3);    
    }
    public static final int MAX_V = (int) 1e9 + 7;
    public int sumOfPowers(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        int[][] dist = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = nums[j] - nums[i];
            }
        }
        return 0;
    }
}