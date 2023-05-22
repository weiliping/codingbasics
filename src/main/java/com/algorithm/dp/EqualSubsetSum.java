package com.algorithm.dp;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets/
 *
 * 698. 划分为k个相等的子集
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 示例 1：
 *
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 *
 *
 * 提示：
 *
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 *
 */
public class EqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = new int[] { 10, 10, 10, 7, 7, 7, 7, 7, 7, 6, 6, 6 };
        System.out.println("res = " + new EqualSubsetSum().canPartitionKSubsets(nums, 3));
        System.out.println("res = " + new EqualSubsetSum().canPartitionKSubsetsII(nums, 3));
        System.out.println(canPart(nums, 3));
    }


    public static boolean canPart(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }

        Arrays.sort(nums);
        int target = sum / k;
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }

        while (nums[row] == target) {
            row--;
            k--;
        }
        return canPartHelper(nums, row, new int[k], target);
    }

    static boolean canPartHelper(int[] nums, int row, int[] group, int target) {
        if (row < 0) {
            return true;
        }
        int v = nums[row--];
        for (int i = 0; i < group.length; i++) {

            if (group[i] + v <= target) {
                group[i] += v;
                if (canPartHelper(nums, row, group, target)) {
                    return true;
                }
                group[i] -= v;
            }
            if (group[i] == 0) {
                break;
            }
        }
        return false;
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }

        Boolean[] memo = new Boolean[1 << nums.length];
        memo[(1 << nums.length) - 1] = Boolean.TRUE;
        return kSubsetsHelper(0, sum, memo, nums, sum / k);
    }

    boolean kSubsetsHelper(int used, int todo, Boolean[] memo, int[] nums, int target) {
        if (memo[used] == null) {
            memo[used] = Boolean.FALSE;
            int targ = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if ((((used >> i) & 1) == 0) && nums[i] <= targ) {
                    if (kSubsetsHelper(used | (1 << i), todo - nums[i], memo, nums, target)) {
                        memo[used] = Boolean.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Boolean.TRUE;
    }

    public boolean canPartitionKSubsetsII(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k > 0) {
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if (nums[row] > target) {
            return false;
        }
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {
            return true;
        }
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            if (groups[i] + v <= target) {
                groups[i] += v;
                if (search(groups, row, nums, target)) {
                    return true;
                }
                groups[i] -= v;
            }
            if (groups[i] == 0) {
                break;
            }
        }
        return false;
    }
}
