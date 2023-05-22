package com.algorithm.contest.weeklycontest228;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/
 * 1761. 一个图中连通三元组的最小度数
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 *  
 * 示例 1：
 * 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * 输出：3
 * 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
 * 示例 2：
 * 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * 输出：0
 * 解释：有 3 个三元组：
 * 1) [1,4,3]，度数为 0 。
 * 2) [2,5,6]，度数为 2 。
 * 3) [5,6,7]，度数为 2 。
 *  
 * 提示：
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 图中没有重复的边。
 */
public class MinimumEdges {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = new int[][] { { 1, 3 }, { 4, 1 }, { 4, 3 }, { 2, 5 }, { 5, 6 }, { 6, 7 }, { 7, 5 }, { 2, 6 } };
        System.out.println(minEdgesI(n, edges));

        int[][] edges2 = new int[][] { { 1, 2 }, { 1, 3 }, { 3, 2 }, { 4, 1 }, { 5, 2 }, { 3, 6 } };
        int n2 = 6;
        System.out.println(minEdgesI(n2, edges2));

        int n3 = 15;
        int[][] edges3 =
                new int[][] { { 6, 15 }, { 12, 10 }, { 14, 7 }, { 4, 6 }, { 14, 10 }, { 3, 10 }, { 5, 1 }, { 4, 15 },
                        { 14, 13 }, { 8, 3 }, { 8, 6 }, { 10, 9 }, { 2, 5 }, { 1, 3 }, { 15, 2 }, { 2, 14 }, { 15, 5 },
                        { 7, 4 }, { 6, 2 }, { 10, 15 }, { 15, 8 }, { 15, 14 }, { 1, 15 }, { 6, 14 }, { 4, 5 }, { 3, 9 },
                        { 5, 6 }, { 3, 6 }, { 4, 14 }, { 5, 9 }, { 8, 2 }, { 3, 12 }, { 3, 15 }, { 8, 5 }, { 11, 4 },
                        { 9, 4 }, { 5, 12 }, { 11, 7 }, { 2, 4 }, { 1, 2 }, { 9, 13 }, { 10, 11 }, { 2, 7 }, { 10, 8 },
                        { 1, 11 }, { 2, 10 }, { 15, 7 }, { 1, 14 }, { 2, 13 }, { 7, 9 }, { 6, 13 }, { 7, 6 }, { 6, 10 },
                        { 8, 11 }, { 3, 2 }, { 14, 5 }, { 3, 14 }, { 5, 11 }, { 4, 13 }, { 8, 1 }, { 10, 4 }, { 11, 9 },
                        { 10, 7 }, { 10, 13 }, { 1, 4 }, { 8, 13 }, { 11, 6 }, { 1, 7 }, { 1, 13 }, { 2, 9 }, { 2, 12 },
                        { 13, 12 }, { 15, 9 }, { 14, 12 } };
        System.out.println(minEdges(n3, edges3));
    }

    public static int minEdgesI(int n, int[][] edges) {
        boolean[][] connections = new boolean[n][n];
        int[] lenDp = new int[n];

        for (int[] e : edges) {
            connections[e[0] - 1][e[1] - 1] = true;
            connections[e[1] - 1][e[0] - 1] = true;
            lenDp[e[0] - 1]++;
            lenDp[e[1] - 1]++;
        }
        int cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (connections[i][j] && connections[j][k] && connections[k][i]) {
                        cnt = Math.min(lenDp[i] + lenDp[j] + lenDp[k] - 6, cnt);
                    }
                }
            }
        }
        return cnt == Integer.MAX_VALUE ? -1 : cnt;
    }

    public static int minEdges(int n, int[][] edges) {
        HashSet<Integer>[] graph = new HashSet[n + 1];
        List<Integer>[] graph2 = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
            graph2[i] = new ArrayList<>();
        }
        int[] lenDp = new int[n + 1];
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            graph2[edge[0]].add(edge[1]);
            graph2[edge[1]].add(edge[0]);
            lenDp[edge[0]]++;
            lenDp[edge[1]]++;
        }

        boolean[][] visit = new boolean[n + 1][n + 1];
        int cnt = Integer.MAX_VALUE;
        for (int p = 1; p <= n; p++) {
            List<Integer> nodes = graph2[p];
            for (int j = 0; j < lenDp[p]; j++) {
                int p1 = nodes.get(j);
                int c = p, r = p1;
                if (p > p1) {
                    c = p1;
                    r = p;
                }
                if (visit[c][r]) {
                    continue;
                }
                HashSet<Integer> nodes2 = graph[p1];
                for (int k = j + 1; k < lenDp[p]; k++) {
                    int p2 = nodes.get(k);
                    int c1 = p1, r1 = p2;
                    if (p1 > p2) {
                        c1 = p2;
                        r1 = p1;
                    }
                    if (visit[c1][r1]) {
                        continue;
                    }
                    if (nodes2.contains(p2)) {
                        cnt = Math.min(lenDp[p] + lenDp[p1] + lenDp[p2] - 6, cnt);
                        if (cnt == 0) {
                            return 0;
                        }
                        visit[c1][r1] = true;
                        if (p > p2) {
                            visit[p2][p] = true;
                            continue;
                        }
                        visit[p][p2] = true;
                    }
                }
                visit[c][r] = true;
            }
        }
        return cnt;
    }
}
