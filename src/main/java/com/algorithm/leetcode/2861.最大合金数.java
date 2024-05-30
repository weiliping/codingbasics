package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2861 lang=java
 *
 * [2861] 最大合金数
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution2861 {
    public static void main(String[] args) {
        System.out.println(new Solution2861().maxNumberOfAlloys(2, 5, 48, Arrays.asList(Arrays.asList(6, 3), Arrays.asList(9, 5), Arrays.asList(1, 9), Arrays.asList(1,8), Arrays.asList(3, 3)), Arrays.asList(4, 8), List.of(10, 1)));
    }
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;
        HashSet<Integer> s = new HashSet<>();
        while (budget > 0) {
            int[] cInd = null;
            if (s.size() < k) {
                cInd = findMinInd(composition, stock, cost);
                s.add(cInd[0]);
            } else {
                cInd = findMinInd(composition, stock, cost, s);
            }
            List<Integer> comp = composition.get(cInd[0]);
            for (int j = 0; j < n; j++) {
                int p = comp.get(j);
                int p1 = Math.min(p, stock.get(j));
                stock.set(j, stock.get(j) - p1);
            }
            if (budget < cInd[1]) {
                break;
            }
            budget -= cInd[1];
            ans += 1;
        }
        return ans;
    }

    public static int[] findMinInd(List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int cV = Integer.MAX_VALUE;
        int cInd = -1; 
        for (int i = 0; i < composition.size(); i++) {
            List<Integer> comp = composition.get(i);
            int curV = 0;
            for (int j = 0; j < comp.size(); j++) {
                int p = comp.get(j);
                int p1 = Math.min(p, stock.get(j));
                curV += (p - p1) * cost.get(j);
            }
            if (cV > curV) {
                cV = curV;
                cInd = i;
            }
        }
        return new int[] {cInd, cV};
    }

    public static int[] findMinInd(List<List<Integer>> composition, List<Integer> stock, List<Integer> cost, HashSet<Integer> s) {
        int cV = Integer.MAX_VALUE;
        int cInd = -1; 
        for (Integer i : s) {
            List<Integer> comp = composition.get(i);
            int curV = 0;
            for (int j = 0; j < comp.size(); j++) {
                int p = comp.get(j);
                int p1 = Math.min(p, stock.get(j));
                curV += (p - p1) * cost.get(j);
            }
            if (cV > curV) {
                cV = curV;
                cInd = i;
            }
        }
        return new int[]{cInd, cV};
    }
}
// @lc code=end

