package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMartixNew {

    /**
     * https://leetcode-cn.com/problems/spiral-matrix/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        int[][] matrix = new int[][]{{2, 5, 8}, {4, 0, -1}};
        int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        //        int[][] matrix = new int[][]{{1, 2, 3, 4}};
        //        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        //        int[][] matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        //        int[][] matrix = new int[][]{{1}, {2}, {3}, {4}};
        //        System.out.println("c = " + matrix[0].length);
        //        System.out.println("r = " + matrix.length);
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }

        if (matrix.length == 1 || matrix[0].length == 1) {
            if (matrix.length == 1) {
                for (int a : matrix[0]) {
                    res.add(a);
                }
                return res;
            }
            for (int i = 0; i < matrix.length; i++) {
                res.add(matrix[i][0]);
            }
            return res;
        }

        int i, j, rStart = 0, cStart = 0, rEnd = matrix.length, cEnd = matrix[0].length;

        while (rStart < rEnd && cStart < cEnd) {
            for (i = cStart; i < cEnd; i++) {
                res.add(matrix[rStart][i]);
            }
            rStart++;

            for (j = rStart; j < rEnd; j++) {
                res.add(matrix[j][cEnd - 1]);
            }
            cEnd--;

            for (i = cEnd - 1; i >= cStart && rEnd > rStart; i--) {
                res.add(matrix[rEnd - 1][i]);
            }
            rEnd--;

            for (j = rEnd - 1; j >= rStart && cEnd > cStart; j--) {
                res.add(matrix[j][cStart]);
            }
            cStart++;

        }
        return res;
    }
}
