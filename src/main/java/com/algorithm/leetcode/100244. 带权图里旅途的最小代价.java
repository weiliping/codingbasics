package com.algorithm.leetcode;

import java.util.Arrays;

class Solution100244 {
    public static final int MAX_V = 262143;
    public static void main(String[] args) {
        Solution100244 s = new Solution100244();
        // int n = 5;
        // int[][] edges = new int[][]{{0,1,7},{1,3,7},{1,2,1}};
        // int[][] query = new int[][]{{0,3},{3,4}};
        // System.out.println(Arrays.toString(s.minimumCost(n, edges, query)));

        int n1 = 9;
        int[][] edges1 = new int[][]{{0,4,7},{3,5,1},{1,3,5},{1,5,1}};
        int[][] query1 = new int[][]{{0,4}, {1,5}, {3,0}, {3,3}, {3,2}, {2,0}, {7,7}, {7,0}};
        
        System.out.println(Arrays.toString(s.minimumCost(n1, edges1, query1))); 
    }

    
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parents = new int[n];
        Arrays.setAll(parents, i -> i);
        int[] weights = new int[n];
        Arrays.fill(weights, MAX_V);
        for (int[] edge : edges) {
            union(parents, edge[0], edge[1], edge[2], weights);
        }
        int m = query.length;
        int[] res = new int[m];
        Arrays.fill(res, -1);
        for (int i = 0; i < m; i++) {
            int[] q = query[i];
            if (q[0] == q[1]) {
                res[i] = 0;
                continue;
            }
            int x = find(parents, q[0]);
            int y = find(parents, q[1]);
            if (x != y) {
                continue;
            }
            res[i] = weights[x];
        }
        return res;
    }

    private static void union(int[] parents, int u, int v, int w,int[] weights) {
        int x = find(parents, u);
        int y = find(parents, v);
        if (x == y) {
            weights[x] &= w; 
            return;
        }
        parents[y] = x;
        weights[x] &= w;
        weights[y] &= w;
        weights[x] &= weights[y]; 
    }

    private static int find(int[] arr, int i) {
        if (arr[i] == i) {
            return i;
        }
        return find(arr, arr[i]);
    }
}
