package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetsII {

    /**
     * #90
     * https://leetcode-cn.com/problems/subsets-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Integer>> res = new SubsetsII().subsetsWithDup(new int[] { 4, 4, 4, 1, 4 });
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        dfs(nums, 0, nums.length, res, out);
        res.add(new ArrayList<Integer>());
        return res;
    }

    static void dfs(int[] nums, int s, int l, List<List<Integer>> res, List<Integer> out) {
        HashSet<Integer> set = new HashSet<>();
        for (int j = s; j < l; j++) {
            if (set.contains(nums[j])) {
                continue;
            }
            set.add(nums[j]);
            out.add(nums[j]);
            res.add(new ArrayList<Integer>(out));
            dfs(nums, j + 1, l, res, out);
            out.remove(out.size() - 1);
        }
    }
}
