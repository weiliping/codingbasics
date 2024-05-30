package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2876 lang=java
 *
 * [2876] 有向图访问计数
 */

// @lc code=start

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2876 {
    public static void main(String[] args) {
        int[] nums1 = new int[] {8, 1};
        int[] nums2 = new int[] {7, 3, 6, 8, 4, 2};

        int money = 10;

        Map<String, String> mp = new HashMap<>();
        

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int amout1 = money - nums2[0];
        int amout2 = money - nums1[0];
        boolean[] dp1 = new boolean[amout1 + 1];
        dp1[0] = true;
        boolean[] dp2 = new boolean[amout2 + 1];
        dp2[0] = true;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = amout1; j >= nums1[i]; j--) {
                dp1[j] |= dp1[j - nums1[i]];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = amout2; j >= nums2[i]; j--) {
                dp1[j] |= dp1[j - nums2[i]];
            }
        }
    }
    // public static void main(String[] args) {
    //     List<Integer> edges = new ArrayList<>();
    //     edges.add(1);
    //     edges.add(2);    
    //     edges.add(0);  
    //     edges.add(0);
    //     Solution2876 s = new Solution2876();
    //     System.out.println(Arrays.toString(s.countVisitedNodes(edges)));
    // }
    public int[] countVisitedNodes(List<Integer> edges) {
        int n = edges.size();
        int[] cirIndex = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (ans[i] != 0) {
                continue;
            }
            detectCircle(edges, i, 1, cirIndex, ans);
            dfsHelper(edges, i, ans);
        }
        return ans;
    }

    public void detectCircle(List<Integer> edges, int i, int v, int[] cirIndex, int[] ans) {
        if (ans[i] != 0) {
            return;
        }
        cirIndex[i] = v;
        int next = edges.get(i);
        if (ans[next] == 0 && cirIndex[next] != 0) {
            int cirV = v - cirIndex[next] + 1;
            ans[next] = cirV;
            dfs(edges, edges.get(next), cirV, ans, next);    
            return;
        } else {
            detectCircle(edges, next, v + 1, cirIndex, ans);
        }
    }

    public int dfsHelper(List<Integer> edges, int i, int[] ans) {
        if (ans[i] != 0) {
            return ans[i];
        }
        ans[i] = dfsHelper(edges, edges.get(i), ans) + 1;
        return ans[i];
    }

    public void dfs(List<Integer> edges, int i, int cirV, int[] ans, int e) {
        if (i == e) {
            return;    
        }
        ans[i] = cirV;
        dfs(edges, edges.get(i), cirV, ans, e);
    }
}
// @lc code=end

