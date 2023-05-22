package com.algorithm.contest.weeklycontest307;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSum {
    public static void main(String[] args) {
        System.out.println(kSum(new int[] { 2, 4, -2 }, 5));
        int nums[] = new int[] { 1, -2, 3, 4, -10, 12 }, k = 16;
        System.out.println(kSum(nums, k));
    }

    public static long kSum(int[] nums, int k) {
        long sum = 0L;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                sum += nums[i];
                continue;
            }
            nums[i] = -nums[i];
        }
        return sum - theKthMinimumSumOfSubsequence(nums, k);
    }

    public static long theKthMinimumSumOfSubsequence(int[] nums, int k) {
        if (k == 1) {
            return 0;
        }
        k--;
        int n = nums.length;
        Arrays.sort(nums);
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> (int) (a[0] - b[0]));
        q.offer(new long[] { nums[0], 0 });
        while (--k > 0) {
            long[] p = q.poll();
            int i = (int) p[1];
            if (i + 1 < n) {
                q.offer(new long[] { p[0] - nums[i] + nums[i + 1], i + 1 });
                q.offer(new long[] { p[0] + nums[i + 1], i + 1 });
            }

        }
        return q.peek()[0];
    }
}
