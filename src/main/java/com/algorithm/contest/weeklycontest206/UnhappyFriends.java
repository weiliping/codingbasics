package com.algorithm.contest.weeklycontest206;

import java.util.HashSet;
import java.util.Set;

public class UnhappyFriends {
    public static void main(String[] args) {
        int n = 4;
        int[][] pre = new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};

        int[][] p = new int[][]{{0, 1}, {2, 3}};
        System.out.println(unhappyFriends(n, pre, p));

        int n1 = 4;
        int[][] pre1 = new int[][]{{ 1,3,2},{2,3,0},{1,3,0},{0,2,1}};
        int[][] p1 = new int[][]{{1, 3}, {0, 2}};
        System.out.println(unhappyFriends(n1, pre1, p1));
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int m = preferences.length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                dp[i][preferences[i][j]] = j;
            }
        }
        int len = pairs.length;
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < len - 1; i++) {
            int[] p = pairs[i];
            for (int j = i + 1; j < len; j++) {
                int[] u = pairs[j];
                if (!s.contains(p[0])) {
                    if (dp[p[0]][u[0]] < dp[p[0]][p[1]] && dp[u[0]][p[0]] < dp[u[0]][u[1]]) {
                        s.add(p[0]);
                    } else if (dp[p[0]][u[1]] < dp[p[0]][p[1]] && dp[u[1]][p[0]] < dp[u[1]][u[0]]) {
                        s.add(p[0]);
                    }
                }
                if (!s.contains(p[1])) {
                    if (dp[p[1]][u[0]] < dp[p[1]][p[0]] && dp[u[0]][p[1]] < dp[u[0]][u[1]]) {
                        s.add(p[1]);
                    } else if (dp[p[1]][u[1]] < dp[p[1]][p[0]] && dp[u[1]][p[1]] < dp[u[1]][u[0]]) {
                        s.add(p[1]);
                    }
                }
                if (!s.contains(u[0])) {
                    if (dp[u[0]][p[0]] < dp[u[0]][u[1]] && dp[p[0]][u[0]] < dp[p[0]][p[1]]) {
                        s.add(u[0]);
                    } else if (dp[u[0]][p[1]] < dp[u[0]][u[1]] && dp[p[1]][u[0]] < dp[p[1]][p[0]]) {
                        s.add(u[0]);
                    }
                }
                if (!s.contains(u[1])) {
                    if (dp[u[1]][p[0]] < dp[u[1]][u[0]] && dp[p[0]][u[1]] < dp[p[0]][p[1]]) {
                        s.add(u[1]);
                    } else if (dp[u[1]][p[1]] < dp[u[1]][u[0]] && dp[p[1]][u[1]] < dp[p[1]][p[0]]) {
                        s.add(u[1]);
                    }
                }
            }
        }
        return s.size();
    }
}
