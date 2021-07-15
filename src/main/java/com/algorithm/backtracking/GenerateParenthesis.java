package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    /**
     * #22
     * https://leetcode-cn.com/problems/generate-parentheses/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> res = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        dfs(n, n, "", res);
        return res;
    }

    static void dfs(int left, int right, String path, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(path);
            return;
        }

        if (left > 0) {
            dfs(left - 1, right, path + "(", res);
        }

        if (left < right) {
            dfs(left, right - 1, path + ")", res);
        }
    }
}
