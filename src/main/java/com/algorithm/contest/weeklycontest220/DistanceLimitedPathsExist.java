package com.algorithm.contest.weeklycontest220;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/checking-existence-of-edge-length-limited-paths/
 *
 * 1697. 检查边长度限制的路径是否存在
 *
 * 给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
 *
 * 给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
 *
 * 请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：n = 3, edgeList = [[0,1,2],[1,2,4],[2,0,8],[1,0,16]], queries = [[0,1,2],[0,2,5]]
 * 输出：[false,true]
 * 解释：上图为给定的输入数据。注意到 0 和 1 之间有两条重边，分别为 2 和 16 。
 * 对于第一个查询，0 和 1 之间没有小于 2 的边，所以我们返回 false 。
 * 对于第二个查询，有一条路径（0 -> 1 -> 2）两条边都小于 5 ，所以这个查询我们返回 true 。
 * 示例 2：
 *
 *
 * 输入：n = 5, edgeList = [[0,1,10],[1,2,5],[2,3,9],[3,4,13]], queries = [[0,4,14],[1,4,13]]
 * 输出：[true,false]
 * 解释：上图为给定数据。
 *  
 *
 * 提示：
 *
 * 2 <= n <= 10^5
 * 1 <= edgeList.length, queries.length <= 10^5
 * edgeList[i].length == 3
 * queries[j].length == 3
 * 0 <= ui, vi, pj, qj <= n - 1
 * ui != vi
 * pj != qj
 * 1 <= disi, limitj <= 10^9
 * 两个点之间可能有 多条 边。
 *
 */
public class DistanceLimitedPathsExist {
    public static void main(String[] args) {
        DistanceLimitedPathsExist d = new DistanceLimitedPathsExist();
//        int n = 3, edgeList[][] = {{0,1,2},{1,2,4},{2,0,8},{1,0,16}}, queries[][] = {{0,1,2},{0,2,5}};
//        System.out.println(Arrays.toString(d.distanceLimitedPathsExist(n, edgeList, queries)));
//        int n2 = 5, edgeList2[][] = {{0,1,10},{1,2,5},{2,3,9},{3,4,13}}, queries2[][] = {{0,4,14},{1,4,13}};
//        System.out.println(Arrays.toString(d.distanceLimitedPathsExist(n2, edgeList2, queries2)));
        int n3 = 13;
        int[][] edgeList3 = new int[][] {{9,1,53},{3,2,66},{12,5,99},{9,7,26},{1,4,78},{11,1,62},{3,10,50},{12,1,71},{12,6,63},{1,10,63},{9,10,88},{9,11,59},{1,4,37},{4,2,63},{0,2,26},{6,12,98},{9,11,99},{4,5,40},{2,8,25},{4,2,35},{8,10,9},{11,9,25},{10,11,11},{7,6,89},{2,4,99},{10,4,63}};
        int[][] queries3 = new int[][] {{9,7,65},{9,6,1},{4,5,34},{10,8,43},{3,7,76},{4,2,15},{7,6,52},{2,0,50},{7,6,62},{1,0,81},{4,5,35},{0,11,86},{12,5,50},{11,2,2},{9,5,6},{12,0,95},{10,6,9},{9,4,73},{6,10,48},{12,0,91},{9,10,58},{9,8,73},{2,3,44},{7,11,83},{5,3,14},{6,2,33}};
//        int[][] queries3 = new int[][] {{9,7,65},{9,6,1},{4,5,34},{10,8,43}};
        System.out.println(Arrays.toString(d.distanceLimitedPathsExist(n3, edgeList3, queries3)));
        System.out.println(Arrays.toString(d.distanceLimitedPathsExistI(n3, edgeList3, queries3)));
        System.out.println(Arrays.toString(d.distanceLimitedPathsExistII(n3, edgeList3, queries3)));
    }

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        boolean[] res = new boolean[m];
        Map<Integer, Integer>[] graph = new HashMap[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new HashMap<>();
        }

        for (int[] edge : edgeList) {
            Map<Integer, Integer> m0 = graph[edge[0]];
            if (!m0.containsKey(edge[1]) || m0.get(edge[1]) > edge[2]) {
                m0.put(edge[1], edge[2]);
            }

            Map<Integer, Integer> m1 = graph[edge[1]];
            if (!m1.containsKey(edge[0]) || m1.get(edge[0]) > edge[2]) {
                m1.put(edge[0], edge[2]);
            }
        }
        Boolean[] visits = new Boolean[n];
        for (int j = 0; j < m; j++) {
            Arrays.fill(visits, null);
            int[] q = queries[j];
            res[j] = dfs(graph, q[0], q[1], q[2], visits);
        }
        return res;
    }

    boolean dfs(Map<Integer, Integer>[] graph, int start, int target, int limit, Boolean[] visits) {
        if (start == target) {
            return true;
        }
        if (visits[start] != null) {
            return visits[start];
        }
        visits[start] = false;
        Map<Integer, Integer> childs = graph[start];
        for (Map.Entry<Integer, Integer> c : childs.entrySet()) {
            int node = c.getKey(), ol = c.getValue();
            if (ol < limit && dfs(graph, node, target, limit, visits)) {
                visits[start] = true;
                break;
            }
        }
        return visits[start];
    }
    static final int N = 100005;
    int[] p = new int[N];
    public boolean[] distanceLimitedPathsExistI(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        boolean[] res = new boolean[m];
        Pair[] pairs = new Pair[m];
        for (int i = 0; i < m; i++) {
            pairs[i] = new Pair(queries[i][0], queries[i][1], queries[i][2], i);
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.limit));
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        for (int i = 1; i < N; i++) {
            p[i] = i;
        }
        int j = 0;
        for (Pair pair : pairs) {
            for (; j < edgeList.length; j++) {
                if (edgeList[j][2] < pair.limit) {
                    p[find(edgeList[j][0])] = find(edgeList[j][1]);
                    continue;
                }
                break;
            }
            res[pair.i] = (find(pair.s) == find(pair.t));
        }

        return res;
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    public boolean[] distanceLimitedPathsExistII(int n, int[][] edgeList, int[][] queries) {
        int m = queries.length;
        boolean[] res = new boolean[m];
        Pair[] que = new Pair[m];

        for (int i = 0; i < m; i++) {
            que[i] = new Pair(queries[i][0], queries[i][1], queries[i][2], i);
        }
        Arrays.sort(que, (a, b) -> a.limit - b.limit);
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int j = 0;
        UnionFind s = new UnionFind(n);
        for (Pair p : que) {
            for (; j < edgeList.length; j++) {
                if (edgeList[j][2] < p.limit) {
                    s.union(edgeList[j][0], edgeList[j][1]);
                    continue;
                }
                break;
            }
            res[p.i] = s.connected(p.s, p.t);
        }
        return res;
    }

    class Pair {
        int s;
        int t;
        int limit;
        int i;

        public Pair(int s, int t, int limit, int i) {
            this.s = s;
            this.t = t;
            this.limit = limit;
            this.i = i;
        }
    }

    class UnionFind {
        int[] p;
        int[] sz;
        int cnt;
        UnionFind(int n) {
            p = new int[n];
            sz = new int[n];
            cnt = n;
            for (int i = 0; i < cnt; i++) {
                p[i] = i;
                sz[i] = 1;
            }
        }

        public int find(int x) {
            if (x != p[x]) {
                p[x] = find(p[x]);
            }
            return p[x];
        }

        public boolean union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) {
                return false;
            }

            if (sz[x] < sz[y]) {
                int t = x;
                x = y;
                y = t;
            }
            p[y] = x;
            sz[x] += sz[y];
            return true;
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
