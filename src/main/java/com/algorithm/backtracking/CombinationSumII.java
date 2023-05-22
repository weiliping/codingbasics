package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    /**
     * #40
     * https://leetcode-cn.com/problems/combination-sum-ii/
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = combinationSumII(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);

        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public static List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, out, res);
        return res;
    }

    static void helper(int[] nums, int start, int target, List<Integer> out, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(out));
            return;
        }
        if (target < 0) {
            return;
        }
        int prev = -1;
        for (int j = start; j < nums.length; j++) {
            if (prev != nums[j]) {
                out.add(nums[j]);
                helper(nums, j + 1, target - nums[j], out, res);
                out.remove(out.size() - 1);
                prev = nums[j];
            }
        }
    }
}
