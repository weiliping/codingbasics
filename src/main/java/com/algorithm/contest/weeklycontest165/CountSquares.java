package com.algorithm.contest.weeklycontest165;

import java.util.PriorityQueue;

public class CountSquares {

    public static void main(String[] args) {
        CountSquares c = new CountSquares();
        int[][] matrix = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
        System.out.println(c.countSquaresI(matrix));

        int[][] matrix2 = new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(c.countSquaresI(matrix2));

        int[][] matrix3 = new int[][] { { 1, 0, 0 }, { 1, 1, 1 } };
        System.out.println(c.countSquaresI(matrix3));

        int[][] matrix4 = new int[][] { {0,1,1,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}};
        System.out.println(c.countSquaresI(matrix4));
    }

    public int countSquaresI(int[][] matrix) {
        int ans = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }

    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][][] sums = new int[m][n][2];
        PriorityQueue<int[]> queue =
                new PriorityQueue<>((a, b) -> a[0] == b[0] ? (a[1] == b[1] ? b[2] - a[2] : b[1] - a[1]) : b[0] - a[0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0 && i == 0) {
                        sums[i][j] = new int[] { 1, 1 };
                    } else if (j == 0) {
                        int[] pre = sums[i - 1][j];
                        sums[i][j] = new int[] { 1, pre[1] + 1 };
                    } else if (i == 0) {
                        int[] pre = sums[i][j - 1];
                        sums[i][j] = new int[] { pre[0] + 1, 1 };
                    } else {
                        int[] left = sums[i][j - 1], up = sums[i - 1][j];

                        sums[i][j] = new int[] { left[0] + 1, up[1] + 1 };
                    }
                    int max = sums[i][j][0] * sums[i][j][1];
                    queue.offer(new int[] { max, i, j });
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] r = queue.poll();
            int[] lens = sums[r[1]][r[2]];

            if (lens[0] == 0 && lens[1] == 0) {
                continue;
            }
            int ur = r[1] + 1 - lens[1];
            int lc = r[2] + 1 - lens[0];

            for (int j = r[2] - 1; j >= lc; j--) {
                sums[r[1]][j] = new int[2];
            }

            for (int i = r[1] - 1; i >= ur; i--) {
                for (int j = r[2]; j >= lc; j--) {
                    sums[i][j] = new int[2];
                }
            }
        }

        int cnt = 0;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (sums[i][j][0] == 0 || sums[i][j][0] == 0) {
                    continue;
                }
                if (sums[i][j][0] == 1) {
                    cnt += sums[i][j][1];
                    continue;
                }
                if (sums[i][j][1] == 1) {
                    cnt += sums[i][j][0];
                    continue;
                }
                int max = sums[i][j][0], min = sums[i][j][0];

                if (max < min) {
                    int t = min;
                    min = max;
                    max = t;
                }

                cnt += (max - min + 1) * countSquares(min);
            }
        }
        return cnt;
    }

    static int countSquares(int n) {
        int sum = 0, j = n;

        while (j > 0) {
            int cur = n - j + 1;
            sum += cur * cur;
            j--;
        }

        return sum;
    }
}
