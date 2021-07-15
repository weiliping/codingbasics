package com.algorithm.arrays;

import java.util.Arrays;

public class MaximumGap {

    public static void main(String[] args) {
        System.out.println(maximumGapII(new int[] {3, 6, 9, 1}));
    }

    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);
        int maxDiff = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            maxDiff = Math.max(maxDiff, nums[i] - nums[i - 1]);
        }
        return maxDiff;
    }
    public static int maximumGapII(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int maxN = Integer.MIN_VALUE, minN = Integer.MAX_VALUE;
        int len = nums.length;
        for (int n : nums) {
            maxN = Math.max(maxN, n);
            minN = Math.min(minN, n);
        }
        int size = (maxN - minN) / len + 1, cnt = (maxN - minN) / size + 1;
        int[] bucket_min = new int[cnt], bucket_max = new int[cnt];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, Integer.MIN_VALUE);

        for (int n : nums) {
            int idx = (n - minN) / size;
            bucket_min[idx] = Math.min(bucket_min[idx], n);
            bucket_max[idx] = Math.max(bucket_max[idx], n);
        }
        int pre = 0, res = 0;

        for (int i = 1; i < cnt; i++) {
            if (bucket_min[i] == Integer.MAX_VALUE || bucket_max[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(bucket_min[i] - bucket_max[pre], res);
            pre = i;
        }
        return res;
    }
}
