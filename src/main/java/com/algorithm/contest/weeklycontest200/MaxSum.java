package com.algorithm.contest.weeklycontest200;

import java.util.HashMap;
import java.util.Map;

public class MaxSum {

    public static final long MOD = 1000000007;
    public static void main(String[] args) {
        int[] nums1 = new int[] { 2, 4, 5, 8, 10 };
        int[] nums2 = new int[] { 4, 6, 8, 9 };
        System.out.println(maxSum(nums1, nums2));
    }

    public static int maxSum(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n1 = nums1.length, n2 = nums2.length;
        long[] dp1 = new long[n1];
        long[] dp2 = new long[n2];
        for (int i = 0; i < n1; i++) {
            map1.put(nums1[i], i);
        }
        for (int i = 0; i < n2; i++) {
            map2.put(nums2[i], i);
        }

        long f1 = dfs(map1, map2,n1 - 1, 1, nums1, nums2, dp1, dp2);
        long f2 = dfs(map1, map2, n2 - 1,  2, nums1, nums2, dp1, dp2);
        return (int) (Math.max(f1, f2) % MOD);
    }

    static long dfs(Map<Integer, Integer> map1, Map<Integer, Integer> map2, int idx, int sp, int[] nums1,
            int[] nums2, long[] dp1, long[] dp2) {
        if (idx < 0) {
            return 0;
        }
        if (sp == 1) {
            if (dp1[idx] > 0) {
                return dp1[idx];
            }
            int currentNum = nums1[idx];
            long ans = 0;
            long preNum = dfs(map1, map2,idx - 1, sp, nums1, nums2, dp1, dp2);
            ans = Math.max(ans, preNum + currentNum);
            Integer idx2 = map2.get(currentNum);
            if (idx2 != null) {
                long pre2Num = dfs(map1, map2, idx2 - 1, 2, nums1, nums2, dp1, dp2);
                ans = Math.max(ans, pre2Num + currentNum);
            }
            dp1[idx] = ans;
            return dp1[idx];
        } else {
            if (dp2[idx] > 0) {
                return dp2[idx];
            }
            int currentNum2 = nums2[idx];
            long ans = 0;
            long preNum2 = dfs(map1, map2, idx - 1, 2, nums1, nums2, dp1, dp2);
            ans = Math.max(ans, preNum2 + currentNum2);
            Integer idx1 = map1.get(currentNum2);
            if (idx1 != null) {
                long preNum1 = dfs(map1, map2, idx1 - 1, 1, nums1, nums2, dp1, dp2);
                ans = Math.max(ans, preNum1 + currentNum2);
            }
            dp2[idx] = ans;
            return dp2[idx];
        }
    }
}
