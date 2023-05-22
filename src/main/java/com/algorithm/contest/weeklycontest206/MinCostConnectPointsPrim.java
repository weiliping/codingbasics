package com.algorithm.contest.weeklycontest206;

import java.util.Arrays;
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
public class MinCostConnectPointsPrim {
    /**
     * execution time: 42 ms - memory: 42.8 MB
     */
    public int miniSpanTreePrim(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph[i][j] = w;
            }
        }

        boolean[] visited = new boolean[n];
        int[] keys = new int[n];
        Arrays.fill(keys, Integer.MAX_VALUE);
        int[] selectedKeys = new int[n];
        keys[0] = 0;
        selectedKeys[0] = -1;
        int cnt = 1, res = 0;
        while (cnt < n) {
            int edge = findMinKeyVertex(keys, visited, n);
            visited[edge] = true;
            for (int i = 0; i < n; i++) {
                if (graph[edge][i] != 0 && !visited[i] && graph[edge][i] < keys[i]) {
                    keys[i] = graph[edge][i];
                    selectedKeys[i] = edge;
                }
            }
            cnt++;
        }

        for (int j = 1; j < n; j++) {
            res += graph[j][selectedKeys[j]];
        }
        return res;
    }

    static int findMinKeyVertex(int[] keys, boolean visited[], int n) {
        int minKey = -1, minVal = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && keys[i] < minVal) {
                minVal = keys[i];
                minKey = i;
            }
        }
        return minKey;
    }
}
