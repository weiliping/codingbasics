package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nqueens {

    /**
     * #51
     * https://leetcode-cn.com/problems/n-queens/
     * https://www.cnblogs.com/huwt/p/10749234.html
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<String>> res = new Nqueens().solveNQueens(4);
        for (List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        int[] c = new int[n];
        queen(c, 0, n, res);
        return res;
    }

    public static boolean isOK(int[] c, int row) {
        for (int i = 0; i < row; i++) {
            //rows stand in same column, \ or /
            if (c[i] == c[row] || c[row] - row == c[i] - i || c[row] + row == c[i] + i) {
                return false;
            }
        }
        return true;
    }

    public static void queen(int[] c, int row, int n, List<List<String>> res) {
        if (row == n) {
            List<String> subRes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(j == c[i] ? "Q" : ".");
                }
                subRes.add(sb.toString());
            }
            res.add(subRes);
            return;
        }
        for (int col = 0; col < n; col++) {
            c[row] = col;
            if (isOK(c, row)) {
                queen(c, row + 1, n, res);
            }
        }
    }
}
