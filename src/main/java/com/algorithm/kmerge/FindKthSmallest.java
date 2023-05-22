package com.algorithm.kmerge;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 *
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 *
 */
public class FindKthSmallest {

    public static void main(String[] args) {
        int[][] martix = new int[][] { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        System.out.println(kthSmallest(martix, 5));
        System.out.println(minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
    }

    public static int kthSmallest(int[][] martix, int k) {
        int n = martix.length;
        int s = martix[0][0], e = martix[n - 1][n - 1];
        while (s < e) {
            int mid = s + (e - s) / 2, smaller = martix[0][0], larger = martix[n - 1][n - 1];
            int[] res = countLessEqual(martix, mid, smaller, larger);

            if (res[0] == k) {
                return res[1];
            }

            if (res[0] < k) {
                s = res[2];
            } else {
                e = res[1];
            }
        }
        return s;
    }

    static int[] countLessEqual(int[][] martix, int mid, int smaller, int larger) {
        int count = 0, n = martix.length, row = n - 1, col = 0;
        while (row >= 0 && col < n) {
            if (martix[row][col] > mid) {
                larger = Math.min(martix[row][col], larger);
                row--;
                continue;
            }
            smaller = Math.max(martix[row][col], smaller);
            count += row + 1;
            col++;
        }
        return new int[] {count, smaller, larger};
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        Map<Integer, Integer> mp = new HashMap<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int ind = i + 1;
            sums[ind] = sums[i] + nums[i];
            mp.put(sums[ind], ind);
            if (target == sums[ind]) {
                if (res > ind) {
                    res = ind;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int k = sums[i] + target;
            if (mp.containsKey(k)) {
                int sub = mp.get(k) - i;
                if (res > sub) {
                    res = sub;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
