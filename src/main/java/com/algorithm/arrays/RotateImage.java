package com.algorithm.arrays;

import java.util.Arrays;

public class RotateImage {

    /**
     * #48
     * https://leetcode-cn.com/problems/rotate-image/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        //        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9} };
        rotate(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }

        for (int i = 0; i < n / 2; i++) {
            int[] tmpRow = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = tmpRow;
        }
    }
}
