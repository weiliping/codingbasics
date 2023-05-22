package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetZeroes {

    /**
     * #73
     * https://leetcode-cn.com/problems/set-matrix-zeroes/
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        setZeroesII(matrix);
        for (int[] nums : matrix) {
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void setZeroesII(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return;
        }
        int r = matrix.length, c = matrix[0].length;
        boolean rowZero = false, colZero = false;

        for (int i = 0; i < r; i++) {
            if (matrix[i][0] == 0) {
                rowZero = true;
            }
        }

        for (int j = 0; j < c; j++) {
            if (matrix[0][j] == 0) {
                colZero = true;
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            for (int i = 0; i < r; i++) {
                matrix[i][0] = 0;
            }
        }

        if (colZero) {
            for (int j = 0; j < c; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix == null || matrix[0] == null) {
            return;
        }
        List<Integer> rowsZero = new ArrayList<>();
        List<Integer> colZero = new ArrayList<>();
        int r = matrix.length, c = matrix[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rowsZero.add(i);
                    colZero.add(j);
                }
            }
        }
        for (int i = 0; i < rowsZero.size(); i++) {
            setZero(matrix, rowsZero.get(i), colZero.get(i), r, c);
        }
    }

    static void setZero(int[][] martix, int i, int j, int r, int c) {
        for (int k = 0; k < r; k++) {
            if (martix[k][j] == 0) {
                continue;
            }
            martix[k][j] = 0;
        }
        for (int l = 0; l < c; l++) {
            if (martix[i][l] == 0) {
                continue;
            }
            martix[i][l] = 0;
        }
    }
}
