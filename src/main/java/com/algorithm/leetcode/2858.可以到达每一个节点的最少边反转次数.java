package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2858 lang=java
 *
 * [2858] 可以到达每一个节点的最少边反转次数
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;

class Solution2858 {
    public int[] minEdgeReversals(int n, int[][] edges) {
        ArrayList<Integer[]>[] graphs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graphs[e[0]].add(new Integer[]{e[1], 0});
            graphs[e[1]].add(new Integer[]{e[0], 1});
        }
        int[][] pVals = new int[n][2];
        int[] cVals = new int[n];
        Arrays.fill(cVals, -1);
        int[] ans = new int[n];
        ans[0] = dfsHelp(graphs, 0, 0, pVals, cVals);
        for (int i = 1; i < n; i++) {
            ans[i] = ans[0] - (pVals[i][0] << 1) + pVals[i][1];
        }
        return ans;
    }

    public static int dfsHelp(ArrayList<Integer[]>[] graphs, int i, int p, int[][] pVals, int[] cVals) {
        if (cVals[i] != -1) {
            return cVals[i];
        }
        ArrayList<Integer[]> childs = graphs[i];
        int res = 0;
        for (Integer[] c: childs) {
            if (c[0] != p) {
                pVals[c[0]][0] = pVals[i][0] + c[1];
                pVals[c[0]][1] = pVals[i][1] + 1;
                res += dfsHelp(graphs, c[0], i, pVals, cVals) + c[1];
            }
        }
        cVals[i] = res;
        return cVals[i];
    }
}
// @lc code=end

