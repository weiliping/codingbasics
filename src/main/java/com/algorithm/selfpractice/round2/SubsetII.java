package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class SubsetII {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2};

        SubsetII subsetII = new SubsetII();
        List<List<Integer>> res = subsetII.subsetsWithoutDup(nums);
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }

    public List<List<Integer>> subsetsWithoutDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null) {
            return res;
        }
        List<Integer> out = new ArrayList<>();
        helper(res, out, 0, nums);
        res.add(new ArrayList<>());
        return res;
    }

    void helper(List<List<Integer>> res, List<Integer> out, int start, int[] nums) {
        HashSet<Integer> unique = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (unique.contains(nums[i])) {
                continue;
            }
            unique.add(nums[i]);
            out.add(nums[i]);
            res.add(new ArrayList<>(out));
            helper(res, out, i + 1, nums);
            out.remove(out.size() - 1);
        }
    }

}
