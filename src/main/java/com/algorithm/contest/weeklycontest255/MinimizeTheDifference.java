package com.algorithm.contest.weeklycontest255;

public class MinimizeTheDifference {

    public static void main(String[] args) {
        MinimizeTheDifference d = new MinimizeTheDifference();
        // int mat[][] = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}}, target = 13;
        // System.out.println(d.minimizeTheDifference(mat, target));
        //
        // int mat1[][] = new int[][] {{1}, {2}, {3}}, target1 = 100;
        // System.out.println(d.minimizeTheDifference(mat1, target1));
        //
        // int mat2[][] = new int[][] {{1,2,9,8,7}}, target2 = 6;
        // System.out.println(d.minimizeTheDifference(mat2, target2));
        //
        // int mat3[][] = new int[][] {{10,3,7,7,9,6,9,8,9,5}, {1,1,6,8,6,7,7,9,3,9},
        // {3,4,4,1,3,6,3,3,9,9}, {6,9,9,3,8,7,9,6,10,6}};
        // int target3 = 5;
        // System.out.println(d.minimizeTheDifferenceI(mat3, target3));

        final int mat4[][] = new int[][] { { 65 }, { 45 }, { 45 }, { 69 }, { 55 }, { 60 }, { 29 }, { 25 }, { 16 },
                { 5 },
                { 62 }, { 16 }, { 29 }, { 19 }, { 34 }, { 2 }, { 24 }, { 32 }, { 66 }, { 62 }, { 60 }, { 46 }, { 42 },
                { 37 }, { 51 }, { 4 }, { 41 }, { 4 }, { 66 }, { 20 }, { 9 }, { 4 }, { 66 }, { 6 }, { 56 }, { 10 },
                { 51 }, { 44 }, { 7 }, { 8 }, { 5 }, { 44 }, { 28 }, { 7 }, { 10 }, { 7 }, { 24 }, { 62 }, { 19 },
                { 14 }, { 45 }, { 68 }, { 9 }, { 14 }, { 51 }, { 28 }, { 8 }, { 57 }, { 59 }, { 6 }, { 54 }, { 8 },
                { 19 }, { 16 }, { 63 }, { 45 }, { 33 }, { 15 }, { 33 }, { 67 } };
        int target4 = 800;
        System.out.println(d.minimizeTheDifferenceII(mat4, target4));
    }

    public int minimizeTheDifferenceII(int[][] mat, int target) {
        boolean[] dp = new boolean[target];
        dp[0] = true;
        int t = Integer.MAX_VALUE, n = mat.length;

        for (int i = 0; i < n; i++) {
            int nextTarget = Integer.MAX_VALUE;
            boolean[] g = new boolean[target];
            for (int x : mat[i]) {
                for (int k = 0; k < target; k++) {
                    if (dp[k]) {
                        if (x + k >= target) {
                            nextTarget = Math.min(nextTarget, x + k);
                        } else {
                            g[x + k] = true;
                        }
                    }
                }
                if (t != Integer.MAX_VALUE) {
                    nextTarget = Math.min(nextTarget, t + x);
                }
            }
            dp = g;
            t = nextTarget;
        }

        int ans = Math.abs(t - target);

        for (int i = target - 1; i >= 0; i--) {
            if (dp[i]) {
                ans = Math.min(ans, target - i);
                break;
            }
        }
        return ans;
    }

    public int minimizeTheDifferenceI(int[][] mat, int target) {
        int n = mat.length, m = mat[0].length;
        int len = 4901;
        boolean dp[][] = new boolean[n][len];

        for (int i = 0; i < m; i++) {
            dp[0][mat[0][i]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (i >= mat[j][k]) {
                        dp[j][i] = dp[j][i] | dp[j - 1][i - mat[j][k]];
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1; i < len; i++) {
            if (dp[n - 1][i]) {
                int sub = Math.abs(target - i);
                if (sub == 0) {
                    return 0;
                }
                if (res > sub) {
                    res = sub;
                }
            }
        }
        return res;
    }

    public int minimizeTheDifference(int[][] mat, int target) {
        int m = mat.length, n = mat[0].length;

        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = mat[0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k] + mat[i][j];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                int sub = Math.abs(target - dp[m - 1][j][k]);
                if (sub == 0) {
                    return 0;
                }
                if (res > sub) {
                    res = sub;
                }
            }
        }
        return res;
    }
}
