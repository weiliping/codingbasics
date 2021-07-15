package com.algorithm.contest.weeklycontest232;

/**
 * https://leetcode-cn.com/problems/maximum-score-of-a-good-subarray/
 * #1793. 好子数组的最大分数
 *
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 *
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 *
 * 请你返回 好 子数组的最大可能 分数 。
 *
 * 示例 1：
 * 输入：nums = [1,4,3,7,4,5], k = 3
 * 输出：15
 * 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 *
 * 示例 2：
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0
 * 输出：20
 * 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 *  
 *
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 104
 * 0 <= k < nums.length
 *
 */
public class MaximumScore {
    public static void main(String[] args) {
        System.out.println(maximumScore(new int[] { 1, 4, 3, 7, 4, 5 }, 3));
        System.out.println(maximumScore(new int[] { 5, 5, 4, 5, 4, 1, 1, 1 }, 0));
    }

    public static int maximumScore(int[] nums, int k) {
        int minValue = nums[k], i = k, j = k, n = nums.length, maxScore = Integer.MIN_VALUE;
        while (true) {
            while (i > 0 && nums[i] >= minValue && nums[i - 1] >= minValue) {
                i--;
            }
            while (j < n - 1 && nums[j] >= minValue && nums[j + 1] >= minValue) {
                j++;
            }
            int maxSub = minValue * (j - i + 1);
            maxScore = Math.max(maxSub, maxScore);
            if (i == 0 && j == n - 1) {
                break;
            }
            int left = i > 0 ? nums[i - 1] : nums[i];
            int right = j < n - 1 ? nums[j + 1] : nums[j];

            if (left > right) {
                if (i == 0) {
                    minValue = right;
                    j++;
                } else {
                    minValue = nums[--i];
                }
            } else {
                if (j == n - 1) {
                    minValue = left;
                    i--;
                } else {
                    minValue = nums[++j];
                }
            }
        }
        return maxScore;
    }
}
