package com.algorithm.arrays;

public class MinimumSizeSubarraySum {

    /**
     * #209
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE, n = nums.length;
        int[] sums = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n, t = sums[i] + s;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (sums[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l == n + 1) {
                break;
            }
            res = Math.min(res, l - i);
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
