package com.algorithm.contest.weeklycontest330;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CountQuadruplets {
    public static void main(String[] args) {
        System.out.println(getInvCount(new int[] { 8, 5, 6, 7, 4, 3, 1, 2 }, 8));
        System.out.println(countQuadruplets(new int[] { 1, 3, 2, 4, 5 }));
        System.out.println(countQuadrupletsII(new int[] { 1, 3, 2, 4, 5 }));
        System.out.println(countQuadruplets(new int[] { 1, 2, 3, 4 }));
        System.out.println(countQuadrupletsII(new int[] { 1, 2, 3, 4 }));
        System.out.println(countQuadruplets(new int[] { 3, 4, 6, 1, 7, 2, 8, 5, 9 }));// 11
        System.out.println(countQuadrupletsII(new int[] { 3, 4, 6, 1, 7, 2, 8, 5, 9 }));// 11
    }

    public static long countQuadrupletsII(int[] nums) {
        long res = 0l;
        int n = nums.length;
        int[][] cnts = new int[n][n + 1];
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j <= i; j++) {
                cnts[i][j] = cnts[i][j - 1];
                if (nums[j - 1] < nums[i]) {
                    cnts[i][j]++;
                }
            }
            for (int k = i + 2; k <= n; k++) {
                cnts[i][k] = cnts[i][k - 1];
                if (nums[k - 1] > nums[i]) {
                    cnts[i][k]++;
                }
            }
        }
        for (int i = 1; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[i] > nums[j]) {
                    res += cnts[j][i] * (cnts[i][n] - cnts[i][j]);
                }
            }
        }
        return res;
    }

    static long query(long[] tree, int i) {
        long ans = 0;
        while (i > 0) {
            ans += tree[i];
            i -= i & (-i);
        }
        return ans;
    }

    static void update(long[] tree, int i, long x, int n) {
        while (i < n) {
            tree[i] += x;
            i += i & (-i);
        }
    }

    public static long countQuadruplets(int[] nums) {
        long res = 0l;
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            for (int j = i + 3; j < n; j++) {
                if (nums[i] + 3 <= nums[j]) {
                    res += getInvCount(nums, n, i, j);
                }
            }
        }
        return res;
    }

    static int getInvCount(int[] nums, int n, int i, int j) {
        int invCount = 0;
        int[] biTree = new int[n + 1];
        for (int k = j - 1; k > i; k--) {
            if (nums[i] < nums[k] && nums[k] < nums[j]) {
                invCount += getSum(biTree, nums[k] - 1);
                updateBIT(biTree, n, nums[k], 1);
            }
        }
        return invCount;
    }

    static int getInvCount(int[] nums, int n) {
        int invCount = 0;
        int[] biTree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int j = getSum(biTree, nums[i] - 1);
            invCount += j;
            updateBIT(biTree, n, nums[i], 1);
        }
        System.out.println(Arrays.toString(biTree));
        return invCount;
    }

    public static int getSum(int[] biTree, int index) {
        int sum = 0;
        while (index > 0) {
            sum += biTree[index];
            index -= index & (-index);
        }
        return sum;
    }

    static void updateBIT(int[] biTree, int n, int index, int val) {
        while (index < n) {
            biTree[index] += val;
            index += index & (-index);
        }
    }
}
