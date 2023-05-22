package com.datastructure.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String args[]) {
        List<List<String>> res = nQueens(4);
        for (List<String> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<String>> nQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int a[] = new int[n];
        helper(res, 0, n, a);
        return res;
    }

    static void helper(List<List<String>> res, int row, int n, int a[]) {
        if (row == n) {
            List<String> subRes = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(a[i] == j ? "Q" : ".");
                }
                subRes.add(sb.toString());
            }
            res.add(subRes);
            return;
        }

        for (int col = 0; col < n; col++) {
            a[row] = col;
            if (isOK(a, row)) {
                helper(res, row + 1, n, a);
            }
        }
    }

    static boolean isOK(int a[], int row) {
        for (int i = 0; i < row; i++) {
            if (a[row] == a[i] || a[row] + row == a[i] + i || a[row] - row == a[i] - i) {
                return false;
            }
        }
        return true;
    }
}
