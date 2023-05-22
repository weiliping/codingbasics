package com.algorithm.backtracking;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/matchsticks-to-square/
 * 473. 火柴拼正方形
 * 还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。
 *
 * 输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。
 *
 * 示例 1:
 *
 * 输入: [1,1,2,2,2]
 * 输出: true
 *
 * 解释: 能拼成一个边长为2的正方形，每边两根火柴。
 * 示例 2:
 *
 * 输入: [3,3,3,3,4]
 * 输出: false
 *
 * 解释: 不能用所有火柴拼成一个正方形。
 * 注意:
 *
 * 给定的火柴长度和在 0 到 10^9之间。
 * 火柴数组的长度不超过15。
 *
 */
public class Makesquare {

    public static void main(String[] args) {
        Makesquare m = new Makesquare();
        System.out.println(m.makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(m.makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(m.makesquare(new int[]{5,5,5,5,4,4,4,4,3,3,3,3}));
    }
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int num : matchsticks) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int n = matchsticks.length;
        int target = (sum >> 2);
        int[] sums = new int[4];
        Arrays.sort(matchsticks);
        return dfs(sums, n - 1, matchsticks, target);
    }

    boolean dfs(int[] sums, int s, int[] nums, int target) {
        if (s == -1) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2]== sums[3];
        }
        int num = nums[s];
        for (int i = 0; i < 4; i++) {
            if (sums[i] + num <= target) {
                sums[i] += num;
                if (dfs(sums, s - 1, nums, target)) {
                    return true;
                }
                sums[i] -= num;
            }
        }
        return false;
    }
}
