package com.algorithm.arrays;

import java.util.Arrays;

public class DiagonalTraverse {

    /**
     * #498
     * https://leetcode-cn.com/problems/diagonal-traverse/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        System.out.println(Arrays.toString(nums));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {};
        }

        if (matrix.length == 1) {
            return matrix[0];
        }

        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] res = new int[m * n];

        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[r][c];

            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    ++r;
                } else if (r == 0) {
                    ++c;
                } else {
                    --r;
                    ++c;
                }
            } else {
                if (r == m - 1) {
                    ++c;
                } else if (c == 0) {
                    ++r;
                } else {
                    ++r;
                    --c;
                }
            }
        }
        return res;
    }
}
