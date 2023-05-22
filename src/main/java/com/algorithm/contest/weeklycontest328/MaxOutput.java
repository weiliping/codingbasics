package com.algorithm.contest.weeklycontest328;

import java.util.ArrayList;
import java.util.List;

public class MaxOutput {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };
        int[] price = new int[] { 9, 8, 7, 6, 10, 5 };
        MaxOutput mx = new MaxOutput();
        System.out.println(mx.maxOutput(n, edges, price));
    }

    public long maxOutput(int n, int[][] edges, int[] price) {
        List<Node>[] graphs = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graphs[edge[0]].add(new Node(edge[1]));
            graphs[edge[1]].add(new Node(edge[0]));
        }
        long[] res = new long[1];
        for (int i = 0; i < n; i++) {
            dfs(graphs, i, price, -1, res);
        }
        return res[0];
    }

    void dfs(List<Node>[] graphs, int ind, int[] price, int p, long[] res) {

        List<Node> graph = graphs[ind];
        if (graph.size() == 1 && p == graph.get(0).i) {
            graph.get(0).maxVal = (long) price[ind];
            return;
        }
        long subMax = 0l;
        for (int j = 0; j < graph.size(); j++) {
            Node preNode = graph.get(j);
            if (p != preNode.i) {
                if (preNode.maxVal == null) {
                    dfs(graphs, preNode.i, price, ind, res);
                }

                if (subMax < graph.get(j).maxVal.longValue()) {
                    subMax = graph.get(j).maxVal.longValue();
                }
                preNode.maxVal = subMax;
            }
        }

        res[0] = Math.max(subMax, res[0]);
    }

    class Node {
        int i;
        Long maxVal;

        public Node(int i) {
            this.i = i;
        }
    }
}
