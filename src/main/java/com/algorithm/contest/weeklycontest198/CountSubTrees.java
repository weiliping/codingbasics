package com.algorithm.contest.weeklycontest198;

import java.util.ArrayList;
import java.util.Arrays;

class CountSubTrees {

    /**
     * #1519
     * https://leetcode-cn.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][] { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } };
        String labels = "abaedcd";
        System.out.println(Arrays.toString(new CountSubTrees().countSubTrees(7, edges, labels)));
    }

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] count = new int[26], sum = new int[n];
        boolean[] visited = new boolean[n];
        countSubTrees(0, visited, sum, count, graph, labels);
        return sum;
    }

    private void countSubTrees(int index, boolean[] visited, int[] sum, int[] count, ArrayList<Integer>[] graph,
            String labels) {
        if (!visited[index]) {
            visited[index] = true;
            for (int i : graph[index]) {
                int[] newCount = new int[26];
                countSubTrees(i, visited, sum, newCount, graph, labels);
                for (int j = 0; j < 26; j++) {
                    count[j] += newCount[j];
                }
                sum[index] += newCount[labels.charAt(index) - 'a'];
            }
            sum[index]++;
            count[labels.charAt(index) - 'a']++;
        }
    }
}
