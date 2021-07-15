package com.algorithm.contest.weeklycontest231;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/number-of-restricted-paths-from-first-to-last-node/
 * #1786. 从第一个节点出发到最后一个节点的受限路径数
 *
 *
 * 现有一个加权无向连通图。给你一个正整数 n ，表示图中有 n 个节点，并按从 1 到 n 给节点编号；另给你一个数组 edges ，其中每个 edges[i] = [ui, vi, weighti] 表示存在一条位于节点 ui 和 vi 之间的边，这条边的权重为 weighti 。
 *
 * 从节点 start 出发到节点 end 的路径是一个形如 [z0, z1, z2, ..., zk] 的节点序列，满足 z0 = start 、zk = end 且在所有符合 0 <= i <= k-1 的节点 zi 和 zi+1 之间存在一条边。
 *
 * 路径的距离定义为这条路径上所有边的权重总和。用 distanceToLastNode(x) 表示节点 n 和 x 之间路径的最短距离。受限路径 为满足 distanceToLastNode(zi) > distanceToLastNode(zi+1) 的一条路径，其中 0 <= i <= k-1 。
 *
 * 返回从节点 1 出发到节点 n 的 受限路径数 。由于数字可能很大，请返回对 109 + 7 取余 的结果。
 *
 * 示例 1：
 * 输入：n = 5, edges = [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]]
 * 输出：3
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。三条受限路径分别是：
 * 1) 1 --> 2 --> 5
 * 2) 1 --> 2 --> 3 --> 5
 * 3) 1 --> 3 --> 5
 *
 * 示例 2：
 * 输入：n = 7, edges = [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]]
 * 输出：1
 * 解释：每个圆包含黑色的节点编号和蓝色的 distanceToLastNode 值。唯一一条受限路径是：1 --> 3 --> 7 。
 *  
 *
 * 提示：
 * 1 <= n <= 2 * 104
 * n - 1 <= edges.length <= 4 * 104
 * edges[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 1 <= weighti <= 105
 * 任意两个节点之间至多存在一条边
 * 任意两个节点之间至少存在一条路径
 */
public class RestrictedPathsSum {
    static int mod = 1000000007;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = new int[][] { { 1, 2, 3 }, { 1, 3, 3 }, { 2, 3, 1 }, { 1, 4, 2 }, { 5, 2, 2 }, { 3, 5, 1 },
                { 5, 4, 10 } };
        System.out.println(countRestrictedPaths(n, edges));
    }
    public static int countRestrictedPaths(int n, int[][] es) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] e : es) {
            int a = e[0], b = e[1], w = e[2];
            Map<Integer, Integer> am = map.getOrDefault(a, new HashMap<>());
            am.put(b, w);
            map.put(a, am);
            Map<Integer, Integer> bm = map.getOrDefault(b, new HashMap<>());
            bm.put(a, w);
            map.put(b, bm);
        }

        int[] dist = new int[n + 1];
        boolean[] st = new boolean[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        Queue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        q.add(new int[] { n, 0 });
        while (!q.isEmpty()) {
            int[] e = q.poll();
            int idx = e[0];
            if (st[idx]) {
                continue;
            }
            st[idx] = true;
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) {
                continue;
            }
            for (int i : mm.keySet()) {
                dist[i] = Math.min(dist[i], dist[idx] + mm.get(i));
                q.add(new int[] { i, dist[i] });
            }
        }

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { i + 1, dist[i + 1] };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);

        int[] f = new int[n + 1];
        f[n] = 1;
        for (int i = 0; i < n; i++) {
            int idx = arr[i][0], cur = arr[i][1];
            Map<Integer, Integer> mm = map.get(idx);
            if (mm == null) {
                continue;
            }
            for (int next : mm.keySet()) {
                if (cur > dist[next]) {
                    f[idx] += f[next];
                    f[idx] %= mod;
                }
            }
            if (idx == 1) {
                break;
            }
        }
        return f[1];
    }
}
