package com.algorithm.selfpractice.round3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSetsII {

    public static void main(String[] args) {
        SubSetsII s = new SubSetsII();
//        List<List<Integer>> res = s.subsetsWithDup(new int[]{1, 2, 2});
//        for (List<Integer> r : res) {
//            System.out.println(Arrays.toString(r.toArray()));
//        }
        List<List<Integer>> res = s.permute(new int[]{1, 2, 3});
        for (List<Integer> r : res) {
            System.out.println(Arrays.toString(r.toArray()));
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, res, new ArrayList<>(), nums.length);
        return res;
    }

    void dfs(int[] nums, int s, List<List<Integer>> res, List<Integer> subRes, int n) {
        Set<Integer> set = new HashSet<>();

        res.add(new ArrayList<>(subRes));

        for (int i = s; i < n; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            subRes.add(nums[i]);
            dfs(nums, i + 1, res, subRes, n);
            subRes.remove(subRes.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        dfs(res, nums, 0, nums.length);
        return res;
    }

    void dfs(List<List<Integer>> res, int[] nums, int s, int n) {
        if (s == n - 1) {
            List<Integer> subRes = new ArrayList<>();
            for (int num : nums) {
                subRes.add(num);
            }

            res.add(subRes);
            return;
        }

        for (int i = s; i < n; i++) {
            swap(nums, s, i);
            dfs(res, nums, s + 1, n);
            swap(nums, i, s);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
