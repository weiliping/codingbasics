package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {
//        List<String> res = generateParenthesis(3);
//        System.out.println(Arrays.toString(res.toArray()));
        for(int i = 0; i < 9; i++) {
            System.out.println(i/3*3);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        dfs(n, n, res, "");
        return res;
    }

    static void dfs(int l, int r, List<String> res, String path) {
        if (l == 0 && r == 0) {
            res.add(path);
            return;
        }

        if (l > 0) {
            dfs(l - 1, r, res, path + "(");
        }

        if (l < r) {
            dfs(l, r - 1, res, path + ")");
        }
    }
}
