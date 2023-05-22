package com.algorithm.contest.weeklycontest234;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * #1806. 还原排列的最少操作步数
 *
 * 给你一个偶数 n​​​​​​ ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i​（下标 从 0 开始 计数）。
 *
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 *
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr​​ 赋值​​给 perm 。
 *
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 *
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 解释：最初，perm = [0,1]
 * 第 1 步操作后，perm = [0,1]
 * 所以，仅需执行 1 步操作
 *
 * 示例 2：
 * 输入：n = 4
 * 输出：2
 * 解释：最初，perm = [0,1,2,3]
 * 第 1 步操作后，perm = [0,2,1,3]
 * 第 2 步操作后，perm = [0,1,2,3]
 * 所以，仅需执行 2 步操作
 *
 * 示例 3：
 * 输入：n = 6
 * 输出：4
 *
 * 提示：
 * 2 <= n <= 1000
 * n​​​​​​ 是一个偶数
 *
 */
public class ReinitializePermutation {
    public static void main(String[] args) {
        System.out.println(reinitializePermutation(2));
        System.out.println(reinitializePermutation(4));
        System.out.println(reinitializePermutation(6));
    }

    public int reinitializePermutationI(int n) {
        int i = 1;
        int step = 0;
        while (i != 1) {
            step++;
            if ((i << 1) < n) { // even
                i <<= 1;
                continue;
            }
            i = (i - n / 2) * 2 + 1; // odd
        }
        return step;
    }

    public static int reinitializePermutation(int n) {
        int[] perm = new int[n];
        Arrays.setAll(perm, i -> i);

        int[] arr = new int[n], curr = Arrays.copyOfRange(perm, 0, perm.length);
        int cnt = 0;
        while (true) {
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = curr[i / 2];
                } else {
                    arr[i] = curr[n / 2 + (i - 1) / 2];
                }
            }
            curr = arr;
            arr = new int[n];
            cnt++;
            if (Arrays.equals(curr, perm)) {
                break;
            }
        }
        return cnt;
    }
}
