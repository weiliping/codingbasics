package com.algorithm.contest.weeklycontest248;

public class FindLength {
    public static void main(String[] args) {
        FindLength f = new FindLength();
        int[] nums1 = new int[]{1, 2, 3, 2, 1}, nums2 = new int[]{3, 2, 1, 4, 7};
        System.out.println(f.findLength(nums1, nums2));
    }
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;

        int[][] dp = new int[n][m];
        int cnt = 0;
        for (int j = 0; j < m; j++) {
            if (nums1[0] == nums2[j]) {
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums1[i] == nums2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (cnt < dp[i][j]) {
                        cnt = dp[i][j];
                    }
                }
            }
        }
        return cnt;
    }
}
