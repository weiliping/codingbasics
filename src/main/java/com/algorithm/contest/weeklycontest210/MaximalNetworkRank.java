package com.algorithm.contest.weeklycontest210;

public class MaximalNetworkRank {
    public static void main(String[] args) {
        MaximalNetworkRank m = new MaximalNetworkRank();
        System.out.println(m.maximalNetworkRank(4, new int[][]{{0,1}, {0,3}, {1,2}, {1,3}}));
        System.out.println(m.maximalNetworkRank(5, new int[][]{{0,1}, {0,3}, {1,2}, {1,3}, {2,3}, {2,4}}));
        System.out.println(m.maximalNetworkRank(8, new int[][]{{0,1}, {1,2}, {2,3}, {2,4}, {5,6}, {5,7}}));
    }
    public int maximalNetworkRank(int n, int[][] roads) {
        int[][] map = new int[n][n];
        int[] inDegree = new int[n];

        for (int[] r : roads) {
            map[r[0]][r[1]]++;
            map[r[1]][r[0]]++;
            inDegree[r[0]]++;
            inDegree[r[1]]++;
        }
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sub = inDegree[i] + inDegree[j] - map[i][j];
                if (res < sub) {
                    res = sub;
                }
            }
        }
        return res;
    }
}
