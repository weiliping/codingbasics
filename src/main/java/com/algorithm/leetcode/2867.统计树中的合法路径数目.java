package com.algorithm.leetcode;
/*
 * @lc app=leetcode.cn id=2867 lang=java
 *
 * [2867] 统计树中的合法路径数目
 */

// @lc code=start

import java.util.ArrayList;

class Solution2867 {
//     public static void main(String[] args) {
//         Solution2867 s = new Solution2867();
//         int[][] edges = new int[][] {{1,2},{1,3},{2,4},{2,5}};
//         int n = 5;
//         System.out.println(s.countPaths(n, edges));
//         int[][] edges2 = new int[][] {{1,2},{1,3},{2,4},{3,5},{3,6}};
//         int n2 = 6;
//         System.out.println(s.countPaths(n2, edges2));
//         int[][] edges3 = new int[][] {{2,1}};
//         int n3 = 2;
//         System.out.println(s.countPaths(n3, edges3));
//         int[][] edges4 = new int[][] {{1,2},{4,1},{3,4}};
//         int n4 = 4;
//         System.out.println(s.countPaths(n4, edges4));
//     }
    static final int N = 100_001;
    static boolean[] PRIMES = new boolean[N];
    static {
        for (int i = 0; i < N; i++) {
            PRIMES[i] = isPrime(i);
        }
    }
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num < 4) {
            return true;
        }

        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 6; i < (int)Math.sqrt(num) + 1; i += 6) {
            if (num % (i - 1) == 0 || num % (i + 1) == 0) {
                return false;
            }
        }
        return true;
    }

    public long countPaths(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (PRIMES[i]) {
                continue;
            }
        }
        return ans;
    }

    void dfs(ArrayList<Integer> child, ArrayList<Integer>[] graph, int i, int p) {
        child.add(i);
        for (int c : graph[i]) {
            if (c != p && !PRIMES[c]) {
                dfs(child, graph, c, i);
            }
        }
    }
}
// @lc code=end

