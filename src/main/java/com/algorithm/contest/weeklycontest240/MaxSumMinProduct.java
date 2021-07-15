package com.algorithm.contest.weeklycontest240;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/maximum-subarray-min-product/
 * # 1856. 子数组最小乘积的最大值
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的 连续 部分。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,2]
 * 输出：14
 * 解释：最小乘积的最大值由子数组 [2,3,2] （最小值是 2）得到。
 * 2 * (2+3+2) = 2 * 7 = 14 。
 *
 * 示例 2：
 * 输入：nums = [2,3,3,1,2]
 * 输出：18
 * 解释：最小乘积的最大值由子数组 [3,3] （最小值是 3）得到。
 * 3 * (3+3) = 3 * 6 = 18 。
 *
 * 示例 3：
 * 输入：nums = [3,1,5,6,4,2]
 * 输出：60
 * 解释：最小乘积的最大值由子数组 [5,6,4] （最小值是 4）得到。
 * 4 * (5+6+4) = 4 * 15 = 60 。
 *  
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 107
 *
 */
public class MaxSumMinProduct {
    public static void main(String[] args) {
        MaxSumMinProduct m = new MaxSumMinProduct();
        System.out.println(m.maxSumMinProduct(new int[] { 1, 2, 3, 2 }));
        System.out.println(m.maxSumMinProduct(new int[] { 2, 3, 3, 1, 2 }));
        System.out.println(m.maxSumMinProduct(new int[] { 3, 1, 5, 6, 4, 2 }));
        System.out.println(m.maxSumMinProduct(new int[] { 4, 1, 1, 1, 2, 2, 5, 5, 1, 5 }));
        System.out.println(m.maxSumMinProduct(new int[] { 1, 1, 1, 1, 1 }));

        System.out.println(m.maxSumMinProductI(new int[] { 1, 1, 3, 2, 2, 2, 1, 5, 1, 5 }));
        System.out.println(
                m.maxSumMinProduct(new int[] { 4, 10, 6, 4, 8, 7, 8, 3, 5, 3, 4, 9, 9, 5, 10, 7, 10, 7, 6, 4 }));

        String arg = args[0];
        String[] strs = arg.split(",");

        int[] nums = new int[strs.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        System.out.println(m.maxSumMinProduct(nums));
    }

    static final int MOD = (int) 1e9 + 7;

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        PriorityQueue<P> queue = new PriorityQueue<>((a, b) -> b.k - a.k);
        long maxPro = -1l;
        queue.offer(new P(nums[0], nums[0]));
        for (int i = 1; i < n; i++) {
            long preSum = 0l;
            while (!queue.isEmpty() && queue.peek().k > nums[i]) {
                P p = queue.poll();
                preSum += p.sum;
                long sub = p.k * preSum;
                if (maxPro < sub) {
                    maxPro = sub;
                }
            }
            long currSum = preSum + nums[i];
            if (queue.isEmpty() || queue.peek().k != nums[i]) {
                queue.offer(new P(nums[i], currSum));
                continue;
            }
            queue.offer(new P(nums[i], queue.poll().sum + currSum));
        }
        long subSum = 0l;
        while (!queue.isEmpty()) {
            P p = queue.poll();
            subSum += p.sum;
            long sub = p.k * subSum;
            if (maxPro < sub) {
                maxPro = sub;
            }
        }
        return (int) (maxPro % MOD);
    }

    class P {
        int k;
        long sum;

        public P(int k, long sum) {
            this.k = k;
            this.sum = sum;
        }
    }

    public int maxSumMinProductI(int[] nums) {
        int n = nums.length;
        long[] res = new long[1];

        Pair[][] dp = new Pair[n][n];
        dfs(nums, n, 0, n - 1, dp, res);
        return (int) (res[0] % MOD);
    }

    Pair dfs(int[] nums, int n, int i, int j, Pair[][] dp, long[] res) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i + 1 == j) {
            long sum = nums[i] + nums[j];
            int minVal = nums[i] > nums[j] ? nums[j] : nums[i];
            long subPro = sum * minVal;
            if (res[0] < subPro) {
                res[0] = subPro;
            }
            dp[i][j] = new Pair(sum, minVal, subPro);
            return dp[i][j];
        }

        Pair leftPart = dfs(nums, n, i, j - 1, dp, res);
        Pair rightPart = dfs(nums, n, i + 1, j, dp, res);
        long subPro = leftPart.pro > rightPart.pro ? leftPart.pro : rightPart.pro;
        long sum = leftPart.sum + nums[j];
        int minVal = leftPart.minVal > nums[j] ? nums[j] : leftPart.minVal;

        long pro = sum * minVal;
        if (subPro < pro) {
            subPro = pro;
        }
        if (res[0] < subPro) {
            res[0] = subPro;
        }
        dp[i][j] = new Pair(sum, minVal, subPro);
        return dp[i][j];
    }

    class Pair {
        long sum;
        int minVal;
        long pro;

        public Pair(long sum, int minVal, long pro) {
            this.sum = sum;
            this.minVal = minVal;
            this.pro = pro;
        }
    }
}
