package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution3148 {
    public static void main(String[] args) {
        Solution3148 s = new Solution3148();
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(List.of(4, 3, 2));
        grid.add(List.of(3, 2, 1));
        // System.out.println(s.maxScore(grid));
        List<List<Integer>> grid3 = new ArrayList<>();
        
        grid3.add(List.of(9,5,7,3));
        grid3.add(List.of(8,9,6,1));
        grid3.add(List.of(6,7,14,3));
        grid3.add(List.of(2,5,3,1));
        System.out.println(s.maxScore(grid3));
        List<List<Integer>> grid1 = new ArrayList<>();
        grid1.add(List.of(6,5,1));
        grid1.add(List.of(5,7,9));
        grid1.add(List.of(6,7,4));
        grid1.add(List.of(6,10,5));
        // System.out.println(s.maxScore(grid1));
    }
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size(), m = grid.get(0).size();
        int[][] dp = new int[n][m];
        dp[0][0] = grid.get(0).get(0);
        
        int ans = Integer.MIN_VALUE;
        for (int j = 1; j < m; j++) {
            int v = grid.get(0).get(j);
            int t = dp[0][j - 1];
            ans = Math.max(ans, v - t);
            dp[0][j] = Math.min(t, v);
        }

        for (int i = 1; i < n; i++) {
            int v = grid.get(i).get(0);
            int t = dp[i - 1][0];
            ans = Math.max(ans, v - t);
            dp[i][0] = Math.min(t, v);            
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int v = grid.get(i).get(j);
                int t = Math.min(dp[i - 1][j], dp[i][j - 1]);
                ans = Math.max(ans, v - t);
                dp[i][j] = Math.min(t, v);
            }
        }
        return ans;
    }
}
