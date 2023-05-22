package com.algorithm.contest.weeklycontest297;

import java.util.Arrays;

public class DistributeCookies {
    public static void main(String[] args) {
        int cookies[] = new int[] { 8, 15, 10, 20, 8 }, k = 2;
        System.out.println(distributeCookiesI(cookies, k));
    }

    public static int distributeCookies(int[] cookies, int k) {
        int n = cookies.length, m = (1 << n);
        int[] sum = new int[m];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    sum[i] += cookies[j];
                }
            }
        }
        System.out.println(Arrays.toString(sum));
        return 0;
    }

    public static int distributeCookiesI(int[] cookies, int k) {
        int[] group = new int[k];
        int[] res = new int[1];
        res[0] = Integer.MAX_VALUE;
        int n = cookies.length;
        canPartHelper(n - 1, group, cookies, k, res);
        return res[0];
    }

    static void canPartHelper(int row, int[] group, int[] nums, int k, int[] res) {
        if (row == -1) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                max = Math.max(group[i], max);
            }
            res[0] = Math.min(res[0], max);
            return;
        }
        int v = nums[row];
        for (int i = 0; i < k; i++) {
            group[i] += v;
            canPartHelper(row - 1, group, nums, k, res);
            group[i] -= v;
            if (group[i] == 0) {
                break;
            }
        }
    }
}
