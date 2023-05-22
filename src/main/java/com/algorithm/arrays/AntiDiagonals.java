package com.algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AntiDiagonals {

    /**
     * https://www.interviewbit.com/problems/anti-diagonals/
     *
     * Description:
     *  Input:
     *
     *  1 2 3
     *  4 5 6
     *  7 8 9
     *
     *  Return the following :
     *
     *  [
     *    [1],
     *    [2, 4],
     *    [3, 5, 7],
     *    [6, 8],
     *    [9]
     *  ]
     * @param args
     */
    public static void main(String[] args) {
        int[][] nums = antiDiagonals(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
        for (int[] n : nums) {
            System.out.println(Arrays.toString(n));
        }
    }

    public static int[][] antiDiagonals(int[][] A) {
        if (A == null || A.length < 2) {
            return A;
        }
        int n = A.length;
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> line = new ArrayList<>();
        for (int d = 0; d <= 2 * (n - 1); d++) {
            for (int i = 0; i <= d; i++) {
                int j = d - i;
                if (i >= n || j >= n) {
                    continue;
                }
                line.add(A[i][j]);
            }
            result.add(line);
            line = new ArrayList<>();
        }
        int[][] r = new int[result.size()][n];

        for (int j = 0; j < result.size(); j++) {
            List<Integer> ol = result.get(j);
            int[] l = new int[ol.size()];
            for (int i = 0; i < ol.size(); i++) {
                l[i] = ol.get(i);
            }
            r[j] = l;
        }
        return r;
    }
}
