package com.algorithm.contest.weeklycontest180;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {

    public static void main(String[] args) {
        LuckyNumbers l = new LuckyNumbers();
//        int[][] matrix = new int[][] {{3,7,8},{9,11,13},{15,16,17}};
//        System.out.println(Arrays.toString(l.luckyNumbers(matrix).toArray()));
//
//        int[][] matrix1 = new int[][] {{1,10,4,2},{9,3,8,7},{15,16,17,12}};
//        System.out.println(Arrays.toString(l.luckyNumbers(matrix1).toArray()));
//
//        int[][] matrix2 = new int[][] {{7,8},{1,2}};
//        System.out.println(Arrays.toString(l.luckyNumbers(matrix2).toArray()));

        int[][] matrix3 = new int[][] {{76618,42558,65788,20503,29400,54116}};
        System.out.println(Arrays.toString(l.luckyNumbers(matrix3).toArray()));
    }
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            int[] max = maxColumn(matrix, j, 0, n - 1);
            int k[] = minRow(matrix, max[0], 0, m - 1);
            if (j == k[0]) {
                res.add(matrix[max[0]][j]);
            }
        }
        return res;
    }


    static int[] maxColumn(int[][] matrix, int j, int s, int e) {
        if (s > e) {
            return new int[]{-1, Integer.MIN_VALUE};
        }

        if (s == e) {
            return new int[]{s, matrix[s][j]};
        }

        if (s + 1 == e) {
            if (matrix[s][j] > matrix[e][j]) {
                return new int[] {s, matrix[s][j]};
            }
            return new int[] {e, matrix[e][j]};
        }

        int mid = s + ((e - s) >> 1);
        int[] left = maxColumn(matrix, j, s, mid), right = maxColumn(matrix, j, mid + 1, e);
        if (left[1] > right[1]) {
            return left;
        }
        return right;
    }

    static int[] minRow(int[][] matrix, int i, int s, int e) {
        if (s > e) {
            return new int[]{-1, Integer.MAX_VALUE};
        }

        if (s == e) {
            return new int[] {s, matrix[i][s]};
        }

        if (s + 1 == e) {
            if (matrix[i][s] < matrix[i][e]) {
                return new int[] {s, matrix[i][s]};
            }
            return new int[] {e, matrix[i][e]};
        }

        int mid = s + ((e - s) >> 1);

        int[] left = minRow(matrix, i, s, mid), right = minRow(matrix, i, mid + 1, e);
        if (left[1] < right[1]) {
            return left;
        }
        return right;
    }
}
