package com.algorithm.selfpractice.round2;

import java.util.ArrayList;
import java.util.List;

public class TreeAncestor {

    public static void main(String[] args) {
        TreeAncestor ancestor = new TreeAncestor(7, new int[] {-1, 0, 0, 1, 1, 2, 2});
        System.out.println(ancestor.getKthAncestor(3, 1));
        System.out.println(ancestor.getKthAncestor(5, 2));
        System.out.println(ancestor.getKthAncestor(6, 3));
    }

    private List<List<Integer>> ancestors;
    public TreeAncestor(int n, int[] parent) {
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

    public int getKthAncestor(int node, int k) {
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
