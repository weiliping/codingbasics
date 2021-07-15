package com.algorithm.contest.weeklycontest231;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/
 * #1787. 使所有区间的异或结果为零
 *
 * 给你一个整数数组 nums​​​ 和一个整数 k​​​​​ 。区间 [left, right]（left <= right）的 异或结果 是对下标位于 left 和 right（包括 left 和 right ）之间所有元素进行 XOR 运算的结果：nums[left] XOR nums[left+1] XOR ... XOR nums[right] 。
 *
 * 返回数组中 要更改的最小元素数 ，以使所有长度为 k 的区间异或结果等于零。
 *
 * 示例 1：
 * 输入：nums = [1,2,0,3,0], k = 1
 * 输出：3
 * 解释：将数组 [1,2,0,3,0] 修改为 [0,0,0,0,0]
 *
 * 示例 2：
 * 输入：nums = [3,4,5,2,1,7,3,4,7], k = 3
 * 输出：3
 * 解释：将数组 [3,4,5,2,1,7,3,4,7] 修改为 [3,4,7,3,4,7,3,4,7]
 *
 * 示例 3：
 * 输入：nums = [1,2,4,1,2,5,1,2,6], k = 3
 * 输出：3
 * 解释：将数组[1,2,4,1,2,5,1,2,6] 修改为 [1,2,3,1,2,3,1,2,3]
 *  
 *
 * 提示：
 * 1 <= k <= nums.length <= 2000
 * ​​​​​​0 <= nums[i] < 210
 */
public class MinChanges {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 4, 1, 2, 5, 1, 2, 6 };
        int k = 3;
        System.out.println(minChanges(nums, k));
    }

    public static int minChanges(int[] nums, int k) {
        int n = nums.length, inf = 100000000;
        int dp[][] = new int[k + 1][1024];
        int m = (n + k - 1) / k;
        int sum = 0, minv = inf;
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], inf);
        }

        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            int len = m;
            if (n % k != 0 && n % k < i) {
                len--;
            }
            int s[] = new int[1024];
            for (int j = 0; j < len; j++) {
                s[nums[j * k + i - 1]]++;
            }
            int maxv = 0;
            for (int j = 0; j < 1024; j++) {
                if (maxv < s[j]) {
                    maxv = s[j];
                }
            }
            if (minv > maxv) {
                minv = maxv;
            }
            sum += len - maxv;
            for (int j = 0; j < len; j++) {
                int x = nums[j * k + i - 1], cost = len - s[x];
                for (int u = 0; u < 1024; u++) {
                    dp[i][u] = Math.min(dp[i][u], dp[i - 1][x ^ u] + cost);
                }
            }
        }
        return Math.min(sum + minv, dp[k][0]);
    }
}
