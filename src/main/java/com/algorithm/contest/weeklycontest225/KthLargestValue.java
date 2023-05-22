package com.algorithm.contest.weeklycontest225;

import java.util.PriorityQueue;

public class KthLargestValue {
    public static void main(String[] args) {
        System.out.println(kthLargestValue(new int[][] {{5, 2}, {1, 6}}, 1));
        System.out.println(kthLargestValue(new int[][] {{5, 2}, {1, 6}}, 2));
        System.out.println(kthLargestValue(new int[][] {{5, 2}, {1, 6}}, 3));
        System.out.println(kthLargestValue(new int[][] {{5, 2}, {1, 6}}, 4));
    }

    public static int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        q.offer(matrix[0][0]);
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] ^ matrix[i][j];
                if (i == 0) {
                    if (q.size() < k) {
                        q.offer(dp[0][j]);
                        continue;
                    }
                    if (q.peek() < dp[0][j]) {
                        q.poll();
                        q.offer(dp[0][j]);
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i][j] = dp[i][j] ^ dp[i - 1][j];
                if (q.size() < k) {
                    q.offer(dp[i][j]);
                    continue;
                }
                if (q.peek() < dp[i][j]) {
                    q.poll();
                    q.offer(dp[i][j]);
                }
            }
        }
        return q.peek();
    }
}
