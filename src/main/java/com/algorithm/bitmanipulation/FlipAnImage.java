package com.algorithm.bitmanipulation;

import java.util.Arrays;

public class FlipAnImage {

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
        flipAndInvertImage(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }

    public static void flipAndInvertImage(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int j = 0, k = matrix[i].length - 1;
            while (j <= k) {
                int t = matrix[i][k]^1;
                matrix[i][k] = matrix[i][j]^1;
                matrix[i][j] = t;
                j++;
                k--;
            }
        }
    }
}
