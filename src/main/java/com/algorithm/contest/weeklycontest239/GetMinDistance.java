package com.algorithm.contest.weeklycontest239;

/**
 * https://leetcode-cn.com/problems/minimum-distance-to-the-target-element/
 * #1848. 到目标元素的最小距离
 *
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 *
 * 返回 abs(i - start) 。
 *
 * 题目数据保证 target 存在于 nums 中。
 *
 * 示例 1：
 * 输入：nums = [1,2,3,4,5], target = 5, start = 3
 * 输出：1
 * 解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
 *
 */
public class GetMinDistance {
    public static void main(String[] args) {
        int nums[] = new int[] { 1, 2, 3, 4, 5 }, target = 5, start = 3;
        System.out.println(new GetMinDistance().getMinDistance(nums, target, start));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int i = start, j = start, n = nums.length, cnt = 0;
        while (i > 0 || j < n) {
            if (nums[i] == target || nums[j] == target) {
                return cnt;
            }
            if (i > 0) {
                i--;
            }
            if (j < n - 1) {
                j++;
            }
            cnt++;
        }
        return cnt;
    }
}
