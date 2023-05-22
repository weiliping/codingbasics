package com.algorithm.contest.weeklycontest229;

/**
 * https://leetcode-cn.com/problems/maximum-score-from-performing-multiplication-operations/
 * 1770. 执行乘法运算的最大分数
 *
 * 给你两个长度分别 n 和 m 的整数数组 nums 和 multipliers ，其中 n >= m ，数组下标 从 1 开始 计数。
 *
 * 初始时，你的分数为 0 。你需要执行恰好 m 步操作。在第 i 步操作（从 1 开始 计数）中，需要：
 *
 * 选择数组 nums 开头处或者末尾处 的整数 x 。
 * 你获得 multipliers[i] * x 分，并累加到你的分数中。
 * 将 x 从数组 nums 中移除。
 * 在执行 m 步操作后，返回 最大 分数。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3], multipliers = [3,2,1]
 * 输出：14
 * 解释：一种最优解决方案如下：
 * - 选择末尾处的整数 3 ，[1,2,3] ，得 3 * 3 = 9 分，累加到分数中。
 * - 选择末尾处的整数 2 ，[1,2] ，得 2 * 2 = 4 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[1] ，得 1 * 1 = 1 分，累加到分数中。
 * 总分数为 9 + 4 + 1 = 14 。
 * 示例 2：
 *
 * 输入：nums = [-5,-3,-3,-2,7,1], multipliers = [-10,-5,3,4,6]
 * 输出：102
 * 解释：一种最优解决方案如下：
 * - 选择开头处的整数 -5 ，[-5,-3,-3,-2,7,1] ，得 -5 * -10 = 50 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-3,-2,7,1] ，得 -3 * -5 = 15 分，累加到分数中。
 * - 选择开头处的整数 -3 ，[-3,-2,7,1] ，得 -3 * 3 = -9 分，累加到分数中。
 * - 选择末尾处的整数 1 ，[-2,7,1] ，得 1 * 4 = 4 分，累加到分数中。
 * - 选择末尾处的整数 7 ，[-2,7] ，得 7 * 6 = 42 分，累加到分数中。
 * 总分数为 50 + 15 - 9 + 4 + 42 = 102 。
 *  
 *
 * 提示：
 *
 * n == nums.length
 * m == multipliers.length
 * 1 <= m <= 10^3
 * m <= n <= 10^5
 * -1000 <= nums[i], multipliers[i] <= 1000
 *
 */
public class MultiplicationOperations {

    static final int MOD = (int) 1e9 + 7;
    public static void main(String[] args) {
        int nums1[] = new int[] { -5, -3, -3, -2, 7, 1 }, mul1[] = new int[] { -10, -5, 3, 4, 6 };
        System.out.println(maximumScore(nums1, mul1));
        int nums2[] = new int[] { 1, 2, 3 }, mul2[] = new int[] { 3, 2, 1 };
        System.out.println(maximumScore(nums2, mul2));
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length, m = multipliers.length;
        int l = 0, r = n - 1, k = 0;
        Integer dp[][] = new Integer[m][m];
        return dfs(nums, multipliers, l, r, k, m, dp);
    }

    static Integer dfs(int[] nums, int[] multipliers, int l, int r, int k, int len, Integer dp[][]) {
        if (len == 0) {
            return 0;
        }
        if (dp[l][k] == null) {
            Integer lSum = nums[l] * multipliers[k] + dfs(nums, multipliers, l + 1, r, k + 1, len - 1, dp);
            Integer rSum = nums[r] * multipliers[k] + dfs(nums, multipliers, l, r - 1, k + 1, len - 1, dp);
            dp[l][k] = Math.max(lSum, rSum);
        }
        return dp[l][k];
    }
}
