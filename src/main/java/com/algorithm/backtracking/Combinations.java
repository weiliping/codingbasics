package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    /**
     * #77
     * https://leetcode-cn.com/problems/combinations
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
        for(List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(n, k, 1, res, out);
        return res;
    }

    static void helper(int n, int k, int level, List<List<Integer>> res, List<Integer> out) {
        if (out.size() == k) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = level; i <= n; i++) {
            out.add(i);
            helper(n, k, i + 1, res, out);
            out.remove(out.size() - 1);
        }
    }
}
