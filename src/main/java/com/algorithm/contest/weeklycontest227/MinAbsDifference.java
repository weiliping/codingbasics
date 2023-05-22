package com.algorithm.contest.weeklycontest227;

import java.util.Arrays;

public class MinAbsDifference {
    public static void main(String[] args) {
//        int[] nums = new int[]{-7933,-1642,-6137,6234,4728,5474,2439};
//        int goal = -428059487;
//        int[] nums = new int[] { 5, -7, 3, 5 };
//        int goal = 6;

        System.out.println((4 >> 0) & 1);
        System.out.println((4 >> 1) & 1);
        System.out.println((4 >> 2) & 1);
//        System.out.println(minAbsDifferenceI(nums, goal));
    }

//428043775
    static int MOD = (int)(1e9 + 7);
    public static int minAbsDifference(int[] nums, int goal) {
        long[] cnt = new long[1], sum = new long[1];
        if (goal > 0) {
            cnt[0] = Integer.MAX_VALUE;
        } else {
            cnt[0] = Integer.MIN_VALUE;
        }
        dfs(nums, 0, goal, sum, cnt);
        return (int) (Math.abs(cnt[0] - goal) % MOD);
    }

    static void dfs(int[] nums, int idx, int goal, long[] sum, long[] cnt) {
        long s = Math.abs(sum[0] - goal);
        if (s < Math.abs(cnt[0] - goal)) {
            cnt[0] = sum[0];
        }
        for (int i = idx; i < nums.length; i++) {
            sum[0] += nums[i];
            dfs(nums, i + 1, goal, sum, cnt);
            sum[0] -= nums[i];
        }
    }

    public static int minAbsDifferenceI(int[] nums, int goal) {
        int n = nums.length;
        int n1 = (n + 1) / 2, n2 = n - n1;
        int len1 = (1 << n1);
        int len2 = (1 << n2);
        int[] f1 = new int[len1], f2 = new int[len2];
        for (int i = 0; i < len1; ++i) {
            for (int j = 0; j < n1; ++j) {
                if (((i >> j) & 1) == 1) {
                    f1[i] += nums[j];
                }
            }
        }
        for (int i = 0; i < (1 << n2); ++i) {
            for (int j = 0; j < n2; ++j) {
                if (((i >> j) & 1) == 1) {
                    f2[i] += nums[n1 + j];
                }
            }
        }
        Arrays.sort(f2);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < f1.length; ++i) {
            int target = goal - f1[i];
            int index = lower_bound(f2, target);
            if (index < f2.length) {
                ans = Math.min(ans, Math.abs(f1[i] + f2[index] - goal));
            }
            if (index - 1 >= 0) {
                ans = Math.min(ans, Math.abs(f1[i] + f2[index - 1] - goal));
            }
        }
        return ans;
    }

    static int lower_bound(int[] g, int target) {
        int l = 0, r = g.length;
        while (l + 1 < r) {
            int mid = l + (r - 1 - l) / 2;
            if (g[mid] < target) {
                l = mid + 1;
            } else if (g[mid] >= target) {
                r = mid + 1;
            }
        }
        return l;
    }
}
