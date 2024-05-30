package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2846 lang=java
 *
 * [2846] 边权重均等查询
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    // public static void main(String[] args) {
    //     int n = 7;
    //     int[][] edges = new int[][]{{0,1,1},{1,2,1},{2,3,1},{3,4,2},{4,5,2},{5,6,2}};
    //     int[][] queries = new int[][]{{0,3},{3,6},{2,6},{0,6}};
    //     Solution2846 s = new Solution2846();
    //     System.out.println(Arrays.toString(s.minOperationsQueries(n, edges, queries)));

    //     int n1 = 8;
    //     int[][] edges1 = new int[][]{{1,2,6},{1,3,4},{2,4,6},{2,5,3},{3,6,6},{3,0,8},{7,0,2}};
    //     int[][] queries1 = new int[][]{{4,6},{0,4},{6,5},{7,4}};
    //     System.out.println(Arrays.toString(s.minOperationsQueries(n1, edges1, queries1)));
    //     int n2 = 1;
    //     int[][] edges2 = new int[0][0];
    //     int[][] queries2 = new int[][]{{0, 0}};
    //     System.out.println(Arrays.toString(s.minOperationsQueries(n2, edges2, queries2)));

    //     int n3 = 6;
    //     int[][] edges3 = new int[][] {{1,3,3},{4,1,3},{0,3,5},{5,4,2},{2,5,1}};
    //     int[][] queries3 = new int[][]{{2,1},{2,0},{3,0},{2,2},{2,5},{4,1},{5,2}};
    //     System.out.println(Arrays.toString(s.minOperationsQueries(n3, edges3, queries3)));
    // }
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        int[][] dp = new int[n][3];
        for (int i = 1; i < n; i++) {
            dp[i][0] = i;
        }
        ArrayList<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e: edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
        dfs(0, -1, 1, graph, dp);
        // int[][]
        int l = queries.length;
        int[] ans = new int[l];
        Map<Long, int[]> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] c = new int[27];
            c[0] = 1;
            mp.put(toKey(i, i), c);
        }
        for (int i = 0; i < l; i++) {
            int p = queries[i][0], q = queries[i][1];
            int[] res = null;

            if (mp.containsKey(toKey(p, q))) {
                res = mp.get(toKey(p, q));
            } else if (mp.containsKey(toKey(q, p))) {
                res = mp.get(toKey(q, p));
            } else {
                dfsHelper(dp, new int[27], p, p, mp);
                dfsHelper(dp, new int[27], q, q, mp);
                res = dfsH(dp, q, q, p, mp);
            }
            
            int sum = 0, m = 0;
            for (int j = 1; j < 27; j++) {
                sum += res[j];
                m = Math.max(m, res[j]);    
            }
            ans[i] = sum - m;
        }
        return ans;
    }

    private long toKey(int i, int j) {
        return 1l * i * 10000 + j;
    }

    int[] dfsH(int[][] dp, int q, int qp, int p, Map<Long, int[]> mp) {
        if (q == -1) {
            return null;
        }
        long k = toKey(p, q);
        if (mp.containsKey(k)) {
            return mp.get(k);
        }
        long k1 = toKey(q, p);
        if (mp.containsKey(k1)) {
            int[] left = mp.get(toKey(q, p));
            int[] right = mp.get(toKey(q,qp)).clone();
            for (int i = 1; i < 27; i++) {
                right[i] += left[i];
            }
            return right;
        }
        return dfsH(dp, dp[q][0], qp, p, mp);
    }

    void dfsHelper(int[][] dp, int[] cnts, int p, int pp, Map<Long, int[]> mp) {
        if (dp[p][0] == -1) {
            return;
        }
        int[] a = dp[p];
        long k = toKey(a[0], pp);
        if (!mp.containsKey(k)) {
            cnts[a[1]]++;
            cnts[0] = 1;
            mp.put(k, cnts);
        }
        dfsHelper(dp, cnts.clone(), a[0], pp, mp);
    }

    void dfs(int i, int p, int d, ArrayList<int[]>[] graph, int[][] dp) {
        ArrayList<int[]> child = graph[i];
        for (int[] c : child) {
            if (c[0] == p) {
                continue;
            }
            dp[c[0]][0] = i;
            dp[c[0]][1] = c[1];
            dp[c[0]][2] = d;
            dfs(c[0], i, d + 1, graph, dp);
        }    
    }
}
// @lc code=end

