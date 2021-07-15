package com.algorithm.arrays;

import java.util.Arrays;

public class SpiralMartixII {

    /**
     * #59
     * https://leetcode-cn.com/problems/spiral-matrix-ii
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = generateSpiralArray(4);
        System.out.println(Arrays.deepToString(nums));
    }

    public static int[][] generateSpiralArray(int n) {
        if (n <= 0) {
            return new int[][] {};
        }

        if (n == 1) {
            return new int[][] { { 1 } };
        }
        int[][] res = new int[n][n];

        int i, j, rStart = 0, cStart = 0, rEnd = n, cEnd = n, val = 1;
        while (rStart < rEnd && cStart < cEnd) {

            for (i = cStart; i < cEnd; i++) {
                res[rStart][i] = val;
                val++;
            }
            rStart++;

            for (j = rStart; j < rEnd; j++) {
                res[j][cEnd - 1] = val;
                val++;
            }
            cEnd--;

            for (i = cEnd - 1; i >= cStart && rStart < rEnd; i--) {
                res[rEnd - 1][i] = val;
                val++;
            }
            rEnd--;

            for (j = rEnd - 1; j >= rStart && cStart < cEnd; j--) {
                res[j][cStart] = val;
                val++;
            }
            cStart++;
        }
        return res;
    }
}
