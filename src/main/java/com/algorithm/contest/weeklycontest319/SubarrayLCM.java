package com.algorithm.contest.weeklycontest319;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubarrayLCM {
    public static void main(String[] args) {
        int nums[] = new int[] { 3, 6, 2, 7, 1 }, k = 6;
        System.out.println(subarrayLCM(nums, k));

        int nums1[] = new int[] { 1 }, k1 = 1;
        System.out.println(subarrayLCM(nums1, k1));

        int nums2[] = new int[] { 2, 1, 1, 5 }, k2 = 5;
        System.out.println(subarrayLCM(nums2, k2));
    }

    public static int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        Set<Integer> validNums = subNums(k);
        for (int i = 0; i < n; i++) {
            if (!validNums.contains(nums[i])) {
                continue;
            }
            if (nums[i] == k) {
                cnt++;
            }
            int subNum = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (!validNums.contains(nums[j])) {
                    break;
                }
                int divNum = subNum * nums[j];
                int d = dfs(subNum, nums[j]);
                subNum = divNum / d;
                if (subNum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int dfs(int i, int j) {
        if (j > i) {
            return dfs(j, i);
        }
        int r = i % j;
        if (r == 0) {
            return j;
        }
        return dfs(j, r);
    }

    static Set<Integer> subNums(int k) {
        Set<Integer> res = new HashSet<>();
        if (k == 1) {
            res.add(1);
            return res;
        }
        int q = k >> 1;
        while (q > 0) {
            if (!res.contains(q)) {
                if (k % q == 0) {
                    res.add(q);
                    res.add(k / q);
                }
            }
            q--;
        }
        return res;
    }
}
