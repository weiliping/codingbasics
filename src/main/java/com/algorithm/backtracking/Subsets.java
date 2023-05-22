package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /**
     * #78
     * https://leetcode-cn.com/problems/subsets/
     *
     * @param args
     */
    public static void main(String[] args) {
        Subsets sets = new Subsets();
        List<List<Integer>> res = sets.subsets(new int[] { 1, 2, 3 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        helper(nums, 0, res, new ArrayList<>());
        return res;
    }

    static void helper(int[] nums, int start, List<List<Integer>> res, List<Integer> sub) {
        res.add(new ArrayList<>(sub));
        for (int j = start; j < nums.length; j++) {
            sub.add(nums[j]);
            helper(nums, j + 1, res, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
