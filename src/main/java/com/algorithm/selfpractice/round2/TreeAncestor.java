package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.List;

public class TreeAncestor {

    public static void main(String[] args) {
//        TreeAncestor ancestor = new TreeAncestor(7, new int[] {-1, 0, 0, 1, 1, 2, 2});
//        System.out.println(ancestor.getKthAncestor(3, 1));
//        System.out.println(ancestor.getKthAncestor(5, 2));
//        System.out.println(ancestor.getKthAncestor(6, 3));

        TreeAncestor ancestor = new TreeAncestor(4, new int[] {-1, 2, 3, 0});
        System.out.println(ancestor.getKthAncestor(2, 3));
        System.out.println(ancestor.getKthAncestor(2, 2));
        System.out.println(ancestor.getKthAncestor(2, 1));
    }
    int[][] dp;
    public TreeAncestor(int n, int[] parent) {
        dp = new int[n + 5][20];
        for(int i = 1; i <= n; i++){
            dp[i][0] = parent[i -1] + 1;
        }
        for(int j = 1; j < 20; j++){
            for(int i = 0; i <= n; i++){
                dp[i][j] = dp[dp[i][j-1]][j-1];
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        int res = node+1;
        for(int i = 0; i < 20; i++){
            if(((1 << i) & k) > 0){
                res = dp[res][i];
            }
        }
        return res - 1;
    }

    private List<List<Integer>> ancestors;
    public void TreeAncestorId(int n, int[] parent) {
        ancestors = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int nodeK = i;
            List<Integer> subRes = new ArrayList<>();
            while(parent[nodeK] > -1) {
                subRes.add(parent[nodeK]);
                nodeK = parent[nodeK];
            }
            ancestors.add(subRes);
        }
    }

    public int getKthAncestorI(int node, int k) {
        if (node > ancestors.size()) {
            return -1;
        }

        List<Integer> parents = ancestors.get(node);

        if (k > parents.size()) {
            return -1;
        }

        return parents.get(k - 1);
    }
}
