package com.algorithm.contest.weeklycontest197;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProbability {
    public static void main(String[] args) {
        int n = 3, edges[][] = {{0,1}, {1,2}, {0,2}}, start = 0, end = 2;
        double[] succProb = new double[] { 0.5, 0.5, 0.2 };

        MaxProbability m = new MaxProbability();
        System.out.println(m.maxProbability(n, edges, succProb, start, end));

        int n1 = 3, edges1[][] = {{0,1}, {1,2}, {0,2}}, start1 = 0, end1 = 2;
        double[] succProb1 = new double[] { 0.5, 0.5, 0.3 };
        System.out.println(m.maxProbability(n1, edges1, succProb1, start1, end1));
        //0.30000

        int n2 = 3, edges2[][] = {{0,1}}, start2 = 0, end2 = 2;
        double[] succProb2 = new double[] { 0.5 };
        System.out.println(m.maxProbability(n2, edges2, succProb2, start2, end2));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] res = new double[1];
        res[0] = Double.MIN_VALUE;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        double[][] probs = new double[n][n];
        int len = edges.length;
        for (int i = 0; i < len; i++) {
            int[] e = edges[i];
            probs[e[0]][e[1]] = succProb[i];
            probs[e[1]][e[0]] = succProb[i];
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        List<Integer> visited = new ArrayList<>();
        visited.add(start);
        dfs(graph, probs, start, end, visited, res, 1.0);
        return res[0] == Double.MIN_VALUE ? 0.0 : res[0];
    }

    void dfs(List<Integer>[] graph, double[][] probs, int s, int e, List<Integer> visited, double[] res, double subRes){
        if (s == e) {
            if (subRes > res[0]) {
                res[0] = subRes;
            }
            return;
        }
        List<Integer> childs = graph[s];
        for (int c : childs) {
            if (!visited.contains(c)) {
                visited.add(c);
                if (res[0] < subRes * probs[s][c]) {
                    dfs(graph, probs, c, e, visited, res, subRes * probs[s][c]);
                }
                visited.remove(visited.size() - 1);
            }
        }
    }

    public double maxProbabilityI(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> graph = new ArrayList<List<Pair>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Pair>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            graph.get(e[0]).add(new Pair(succProb[i], e[1]));
            graph.get(e[1]).add(new Pair(succProb[i], e[0]));
        }

        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        double[] prob = new double[n];

        que.offer(new Pair(1, start));
        prob[start] = 1;
        while (!que.isEmpty()) {
            Pair pair = que.poll();
            double pr = pair.probability;
            int node = pair.node;
            if (pr < prob[node]) {
                continue;
            }
            for (Pair pairNext : graph.get(node)) {
                double prNext = pairNext.probability;
                int nodeNext = pairNext.node;
                if (prob[nodeNext] < prob[node] * prNext) {
                    prob[nodeNext] = prob[node] * prNext;
                    que.offer(new Pair(prob[nodeNext], nodeNext));
                }
            }
        }
        return prob[end];
    }
}

class Pair implements Comparable<Pair> {
    double probability;
    int node;

    public Pair(double probability, int node) {
        this.probability = probability;
        this.node = node;
    }

    public int compareTo(Pair pair2) {
        if (this.probability == pair2.probability) {
            return this.node - pair2.node;
        } else {
            return this.probability - pair2.probability > 0 ? -1 : 1;
        }
    }
}
