package com.algorithm.contest.weeklycontest171;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/number-of-operations-to-make-network-connected/
 * 1319. 连通网络的操作次数
 *
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。
 *
 * 网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。
 *
 * 给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 
 *
 *
 * 示例 1：
 * 输入：n = 4, connections = [[0,1],[0,2],[1,2]]
 * 输出：1
 * 解释：拔下计算机 1 和 2 之间的线缆，并将它插到计算机 1 和 3 上。
 *
 * 示例 2：
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
 * 输出：2
 *
 * 示例 3：
 * 输入：n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
 * 输出：-1
 * 解释：线缆数量不足。
 * 示例 4：
 *
 * 输入：n = 5, connections = [[0,1],[0,2],[3,4],[2,3]]
 * 输出：0
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^5
 * 1 <= connections.length <= min(n*(n-1)/2, 10^5)
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] < n
 * connections[i][0] != connections[i][1]
 * 没有重复的连接。
 * 两台计算机不会通过多条线缆连接。
 *
 */
public class MakeConnected {
    public static void main(String[] args) {
        int n1 = 4, conns1[][] = new int[][] {{0,1},{0,2},{1,2}};
        System.out.println(makeConnected(n1, conns1));
        int n2 = 6, conns2[][] = new int[][] {{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(makeConnected(n2, conns2));
        int n3 = 6, conns3[][] = new int[][] {{0,1},{0,2},{0,3},{1,2}};
        System.out.println(makeConnected(n3, conns3));
        int n4 = 5, conns4[][] = new int[][] {{0,1},{0,2},{3,4},{2,3}};
        System.out.println(makeConnected(n4, conns4));
        int n5 = 12, conns5[][] = new int[][] {{1,5},{1,7},{1,2},{1,4},{3,7},{4,7},{3,5},{0,6},{0,1},{0,4},{2,6},{0,3},{0,2}};
        System.out.println(makeConnected(n5, conns5));

        int n6 = 11, conns6[][] = new int[][] {{1,4},{0,3},{1,3},{3,7},{2,7},{0,1},{2,4},{3,6},{5,6},{6,7},{4,7},{0,7},{5,7}};
        System.out.println(makeConnected(n6, conns6));

        int n7 = 100, conns7[][] = new int[][] {{17,51},{33,83},{53,62},{25,34},{35,90},{29,41},{14,53},{40,84},{41,64},{13,68},{44,85},{57,58},{50,74},{20,69},{15,62},{25,88},{4,56},{37,39},{30,62},{69,79},{33,85},{24,83},{35,77},{2,73},{6,28},{46,98},{11,82},{29,72},{67,71},{12,49},{42,56},{56,65},{40,70},{24,64},{29,51},{20,27},{45,88},{58,92},{60,99},{33,46},{19,69},{33,89},{54,82},{16,50},{35,73},{19,45},{19,72},{1,79},{27,80},{22,41},{52,61},{50,85},{27,45},{4,84},{11,96},{0,99},{29,94},{9,19},{66,99},{20,39},{16,85},{12,27},{16,67},{61,80},{67,83},{16,17},{24,27},{16,25},{41,79},{51,95},{46,47},{27,51},{31,44},{0,69},{61,63},{33,95},{17,88},{70,87},{40,42},{21,42},{67,77},{33,65},{3,25},{39,83},{34,40},{15,79},{30,90},{58,95},{45,56},{37,48},{24,91},{31,93},{83,90},{17,86},{61,65},{15,48},{34,56},{12,26},{39,98},{1,48},{21,76},{72,96},{30,69},{46,80},{6,29},{29,81},{22,77},{85,90},{79,83},{6,26},{33,57},{3,65},{63,84},{77,94},{26,90},{64,77},{0,3},{27,97},{66,89},{18,77},{27,43}};
        System.out.println(makeConnectedI(n7, conns7));
    }

    public static int makeConnectedI(int n, int[][] connections) {
        int cnt = 0;
        int[] parents = new int[n];
        Arrays.setAll(parents, i -> i);
        int unused = 0;
        for(int[] con : connections) {
            int q = find(parents, con[0]);
            int p = find(parents, con[1]);
            if (q != p) {
                parents[p] = q;
            } else {
                unused++;
            }
        }
        int parent = -1;
        for (int i = 0; i < n; i++) {
            int j = find(parents, i);
            if (parent == -1) {
                parent = j;
                continue;
            }
            if (parent != j) {
                parents[j] = parent;
                cnt++;
                unused--;
            }
            if (unused == -1) {
                return -1;
            }
        }
        return cnt;
    }

    public static int find(int[] parents, int x) {
        while (x != parents[x]) {
            x = parents[x];
        }
        return x;
    }

    public static int makeConnected(int n, int[][] connections) {
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        List<Integer>[] graph = new ArrayList[n];
        Integer[][] roads = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] con : connections) {
            graph[con[1]].add(con[0]);
            graph[con[0]].add(con[1]);
            if (con[0] > con[1]) {
                roads[con[1]][con[0]] = 1;
            } else {
                roads[con[0]][con[1]] = 1;
            }
        }

        dfs(parents, 0, graph, roads);
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (parents[i] != 0) {
                parents[i] = 0;
                dfs(parents, i, graph, roads);
                cnt++;
            }
        }

        int countUnused = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (roads[i][j] != null && roads[i][j] == 1) {
                    countUnused++;
                }
            }
        }
        if (cnt > countUnused) {
            return -1;
        }
        return cnt;
    }

    static void dfs(int[] parents, int i, List<Integer>[] graph, Integer[][] roads) {
        List<Integer> childs = graph[i];
        for (int j : childs) {
            if (j == 0 || parents[j] != -1) {
                continue;
            }
            if (i == 0 || parents[i] == 0) {
                parents[j] = 0;
                if (i > j) {
                    roads[j][i] = 0;
                } else {
                    roads[i][j] = 0;
                }
            }
            dfs(parents, j, graph, roads);
        }
    }

    class Solution {
        public int makeConnected(int n, int[][] connections) {
            if (connections.length < n - 1) {
                return -1;
            }

            UnionFind uf = new UnionFind(n);
            for (int[] conn : connections) {
                uf.unite(conn[0], conn[1]);
            }

            return uf.setCount - 1;
        }
    }

    // 并查集模板
    class UnionFind {
        int[] parent;
        int[] size;
        int n;
        // 当前连通分量数目
        int setCount;

        public UnionFind(int n) {
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }
    }
}
