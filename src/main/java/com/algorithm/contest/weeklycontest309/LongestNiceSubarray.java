package com.algorithm.contest.weeklycontest309;

public class LongestNiceSubarray {
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[] { 1, 3, 8, 48, 10 }));
        System.out.println(longestNiceSubarray(new int[] { 3, 1, 5, 11, 13 }));
    }

    public static int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[][] sums = new int[n + 1][31];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 31; j++) {
                sums[i][j] += sums[i - 1][j];
                if (((nums[i - 1] >> j) & 1) == 1) {
                    sums[i][j]++;
                }
            }
        }
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            cnt = Math.max(cnt, binarySearch(i, n + 1, sums) - i);
        }
        return cnt;
    }

    static int binarySearch(int i, int n, int[][] bins) {
        int l = i, r = n - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            boolean hasMore = false;
            for (int j = 0; j < 31; j++) {
                if (bins[mid][j] - bins[i - 1][j] > 1) {
                    hasMore = true;
                    break;
                }
            }
            if (hasMore) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
