package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {

    /**
     * #216
     * https://leetcode-cn.com/problems/combination-sum-iii
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3, 9);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(k, 1, n, res, out);
        return res;
    }

    static void helper(int k, int start, int target, List<List<Integer>> res, List<Integer> out) {
        if (target == 0 && out.size() == k) {
            res.add(new ArrayList<>(out));
            return;
        }

        for (int i = start; i <= 9; i++) {
            out.add(i);
            helper(k, i + 1, target - i, res, out);
            out.remove(out.size() - 1);
        }
    }
}
