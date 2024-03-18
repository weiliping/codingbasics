package com.algorithm.contest.weeklycontest382;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumLength {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] s = new long[n + 1];
        Map<Integer, List<Integer>> inds = new HashMap<>();
        for (int i = 0; i < n; i++) {
            s[i + 1] = s[i] + nums[i];
            int key = nums[i];
            List<Integer> arr = inds.get(key);
            if (arr == null || arr.size() == 0) {
                arr = new ArrayList<>();
            }
            arr.add(i);
            inds.put(key, arr);
        }
        long maxV = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int nextV = nums[i] - k;
            if (inds.containsKey(nextV)) {
                for (Integer j : inds.get(nextV)) {
                    if (i < j) {
                        long sub = s[j + 1] - s[i];
                        if (maxV < sub) {
                            maxV = sub;
                        }
                    }
                }
            }
            nextV = nums[i] + k;
            if (inds.containsKey(nextV)) {
                for (Integer j : inds.get(nextV)) {
                    if (i < j) {
                        long sub = s[j + 1] - s[i];
                        if (maxV < sub) {
                            maxV = sub;
                        }
                    }
                }
            }
        }
        return maxV == Long.MIN_VALUE ? 0 : maxV;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { -1, -2, -3, -4 };
        MaximumLength s = new MaximumLength();
        System.out.println(s.maximumSubarraySum(nums, 2));
    }
}
