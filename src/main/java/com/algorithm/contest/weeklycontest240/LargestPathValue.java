package com.algorithm.contest.weeklycontest240;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/largest-color-value-in-a-directed-graph/
 * #1857. 有向图中最大颜色值
 * 给你一个 有向图 ，它含有 n 个节点和 m 条边。节点编号从 0 到 n - 1 。
 *
 * 给你一个字符串 colors ，其中 colors[i] 是小写英文字母，表示图中第 i 个节点的 颜色 （下标从 0 开始）。同时给你一个二维数组 edges ，其中 edges[j] = [aj, bj] 表示从节点 aj 到节点 bj 有一条 有向边 。
 *
 * 图中一条有效 路径 是一个点序列 x1 -> x2 -> x3 -> ... -> xk ，对于所有 1 <= i < k ，从 xi 到 xi+1 在图中有一条有向边。路径的 颜色值 是路径中 出现次数最多 颜色的节点数目。
 *
 * 请你返回给定图中有效路径里面的 最大颜色值 。如果图中含有环，请返回 -1 。
 *
 * 示例 1：
 * 输入：colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
 * 输出：3
 * 解释：路径 0 -> 2 -> 3 -> 4 含有 3 个颜色为 "a" 的节点（上图中的红色节点）。
 *
 * 示例 2：
 * 输入：colors = "a", edges = [[0,0]]
 * 输出：-1
 * 解释：从 0 到 0 有一个环。
 *  
 *
 * 提示：
 * n == colors.length
 * m == edges.length
 * 1 <= n <= 105
 * 0 <= m <= 105
 * colors 只含有小写英文字母。
 * 0 <= aj, bj < n
 */
public class LargestPathValue {
    public static void main(String[] args) {
        LargestPathValue l = new LargestPathValue();
        System.out.println(l.largestPathValue("abaca", new int[][] { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 3, 4 } }));
        System.out.println(l.largestPathValue("a", new int[][] { { 0, 0 } }));
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        int[] inDegrees = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            inDegrees[e[1]]++;
            graph[e[0]].add(e[1]);
        }

        int[][] f = new int[n][26];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        int found = 0;
        while (!q.isEmpty()) {
            found++;
            Integer u = q.poll();
            f[u][colors.charAt(u) - 'a']++;

            for (int next : graph[u]) {
                for (int c = 0; c < 26; c++) {
                    f[next][c] = Math.max(f[next][c], f[u][c]);
                }
                inDegrees[next]--;

                if (inDegrees[next] == 0) {
                    q.offer(next);
                }
            }
        }

        if (found != n) {
            return -1;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (res < f[i][j]) {
                    res = f[i][j];
                }
            }
        }
        return res;
    }
}
