package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    /**
     * #39
     * https://leetcode-cn.com/problems/combination-sum
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = new int[] { 8, 7, 4, 3 };
        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, 11);

        for (List<Integer> sub : res) {
            System.out.println(Arrays.toString(sub.toArray()));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> out = new ArrayList<>();

        helper(candidates, 0, target, res, out);
        return res;
    }

    void helper(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> out) {
        if (target == 0) {
            res.add(new ArrayList<>(out));
            return;
        }
        for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
            out.add(candidates[i]);
            helper(candidates, i, target - candidates[i], res, out);
            out.remove(out.size() - 1);
        }
    }
}
