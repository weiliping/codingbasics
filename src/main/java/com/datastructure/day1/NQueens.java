package com.datastructure.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        NQueens queens = new NQueens();
        List<List<String>> res = queens.solveNQueens(4);
        for (List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        int c[] = new int[n];
        queen(res, c,0, n);
        return res;
    }

    static void queen(List<List<String>> res, int c[], int row, int n) {
        if (row == n) {
            List<String> subRes = new ArrayList<>();
            StringBuilder sb;
            for (int i = 0; i < n; i++) {
                sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(c[i] == j ? "Q" : ".");
                }
                subRes.add(sb.toString());
            }
            res.add(subRes);
            return;
        }

        for (int col = 0; col < n; col++) {
            c[row] = col;
            if (isOK(c, row)) {
                queen(res, c, row + 1, n);
            }
        }
    }

    static boolean isOK(int c[], int row) {
        for (int i = 0; i < row; i++) {
            if (c[i] == c[row] || c[row] + row == c[i] + i || c[row] - row == c[i] - i) {
                return false;
            }
        }
        return true;
    }
}
