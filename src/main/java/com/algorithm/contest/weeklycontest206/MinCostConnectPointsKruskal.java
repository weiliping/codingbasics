package com.algorithm.contest.weeklycontest206;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 *
 * 1584. 连接所有点的最小费用
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 *
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 *
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * 输出：20
 * 解释：
 *
 * 我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
 * 注意到任意两个点之间只有唯一一条路径互相到达。
 * 示例 2：
 *
 * 输入：points = [[3,12],[-2,5],[-4,1]]
 * 输出：18
 * 示例 3：
 *
 * 输入：points = [[0,0],[1,1],[1,0],[-1,1]]
 * 输出：4
 * 示例 4：
 *
 * 输入：points = [[-1000000,-1000000],[1000000,1000000]]
 * 输出：4000000
 * 示例 5：
 *
 * 输入：points = [[0,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= points.length <= 1000
 * -10^6 <= xi, yi <= 10^6
 * 所有点 (xi, yi) 两两不同。
 *
 */
public class MinCostConnectPointsKruskal {

    public static void main(String[] args) {
        int[][] points = new int[][] { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
        MinCostConnectPointsKruskal d = new MinCostConnectPointsKruskal();
        MinCostConnectPointsPrim d2 = new MinCostConnectPointsPrim();
        System.out.println(d.minCostConnectPoints(points));
        System.out.println(d2.miniSpanTreePrim(points));

        int[][] points1 = new int[][] { { 3, 12 }, { -2, 5 }, { -4, 1 } };
        System.out.println(d.minCostConnectPoints(points1));
        System.out.println(d2.miniSpanTreePrim(points1));

        int[][] points2 = new int[][] { { 0, 0 }, { 1, 1 }, { 1, 0 }, { -1, 1 } };
        System.out.println(d.minCostConnectPoints(points2));
        System.out.println(d2.miniSpanTreePrim(points2));
        int[][] points3 = new int[][] { { -1000000, -1000000 }, { 1000000, 1000000 } };
        System.out.println(d.minCostConnectPoints(points3));
        System.out.println(d2.miniSpanTreePrim(points3));
        int[][] points4 = new int[][] { { 0, 0 } };
        System.out.println(d.minCostConnectPoints(points4));
        System.out.println(d2.miniSpanTreePrim(points4));
    }
    /**
     * execution time: 403 ms - memory:	63.7 MB
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        return miniSpanTreeKruskal(points);
    }

    int miniSpanTreeKruskal(int[][] points) {
        int n = points.length;
        List<Edge> graph = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                Edge e = new Edge(i, j, w);
                graph.add(e);
            }
        }
        graph.sort(Comparator.comparingInt(a -> a.w));
        int[] parents = new int[n];
        int weight = 0, cnt = 0, p, q;
        for (Edge e : graph) {
            p = find(parents, e.s);
            q = find(parents, e.e);
            if (p != q) {
                weight += e.w;
                parents[p] = q;
                cnt++;
                if (cnt == n - 1) {
                    break;
                }
            }
        }
        return weight;
    }

    static int find(int[] parents, int f) {
        while (parents[f] > 0) {
            f = parents[f];
        }
        return f;
    }

    class Edge {
        int s;
        int e;
        int w;

        public Edge(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
