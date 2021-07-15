package com.algorithm.dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindCheapestPrice {
    /**
     * #787
     * https://leetcode-cn.com/problems/cheapest-flights-within-k-stops
     * @param args
     */
    public static void main(String[] args) {

//        int n = 3, src = 0, dst = 2, K = 0;
//        int[][] flights = new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
//        FindCheapestPrice t = new FindCheapestPrice();
//        System.out.println(t.findCheapestPrice(n, flights, src, dst, K));

//        int n = 5, src = 0, dst = 4, K = 1;
//        int[][] flights = new int[][] {{1,2,10},{2,0,7},{1,3,8},{4,0,10},{3,4,2},{4,2,10},{0,3,3},{3,1,6},{2,4,5}};
//        FindCheapestPrice t = new FindCheapestPrice();
//        System.out.println(t.findCheapestPrice(n, flights, src, dst, K));

//        int n = 10, src = 6, dst = 0, K = 7;
//        int[][] flights = new int[][] { { 3, 4, 4 }, { 2, 5, 6 }, { 4, 7, 10 }, { 9, 6, 5 }, { 7, 4, 4 }, { 6, 2, 10 },
//                { 6, 8, 6 }, { 7, 9, 4 }, { 1, 5, 4 }, { 1, 0, 4 }, { 9, 7, 3 }, { 7, 0, 5 }, { 6, 5, 8 }, { 1, 7, 6 },
//                { 4, 0, 9 }, { 5, 9, 1 }, { 8, 7, 3 }, { 1, 2, 6 }, { 4, 1, 5 }, { 5, 2, 4 }, { 1, 9, 1 }, { 7, 8, 10 },
//                { 0, 4, 2 }, { 7, 2, 8 } };
//        FindCheapestPrice t = new FindCheapestPrice();
//        System.out.println(t.findCheapestPrice(n, flights, src, dst, K));
        int n = 4, src = 0, dst = 3, K = 1;
        int[][] flights = new int[][] { {0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        FindCheapestPrice t = new FindCheapestPrice();
        System.out.println(t.findCheapestPriceII(n, flights, src, dst, K));
    }

    public int findCheapestPriceII(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];

        for (int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.offer(new int[]{0, 0, src});

        Map<Integer, Integer> best = new HashMap<>();
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int cost = curr[0], k = curr[1], p = curr[2];

            if (k > K + 1 || cost > best.getOrDefault(k * 1000 + p, Integer.MAX_VALUE)) {
                continue;
            }

            if (p == dst) {
                return cost;
            }

            for (int j = 0; j < n; j++) {
                if (graph[p][j] > 0) {
                    int newCost = graph[p][j] + cost;
                    if (newCost < best.getOrDefault((k+1) * 1000 + j, Integer.MAX_VALUE)) {
                        queue.offer(new int[] {newCost, k + 1, j});
                        best.put((k+1) * 1000 + j, newCost);
                    }
                }
            }
        }
        return -1;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<Integer>[]> grah = new HashMap();
        for (int[] f : flights) {
            List<Integer>[] g = grah.getOrDefault(f[0], new ArrayList[3]);
            if (g[0] == null) {
                g[0] = new ArrayList<>();
                g[1] = new ArrayList<>();
                g[2] = new ArrayList<>();
            }
            g[0].add(f[0]);
            g[1].add(f[1]);
            g[2].add(f[2]);
            grah.put(f[0], g);
        }

        Queue<List<Integer>[]> queue = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        if (grah.get(src) != null) {
            queue.offer(grah.get(src));
            qIndex.offer(src);
        }
        K--;
        Set<Integer> visited = new HashSet<>();
        visited.add(src);
        int cns = -1;
        int[] dp = new int[n];
        while (!queue.isEmpty()) {
            List<Integer>[] cur = queue.poll();
            if (K <= -1) {
                break;
            }
            if (cur == null) {
                K--;
                continue;
            }
            Integer indx = qIndex.poll();
            if (cur[1].contains(dst)) {
               int idx = cur[1].indexOf(dst);
               int tmpSrc = cur[0].get(idx);
               int curFee = cur[2].get(idx);
               if (cns == -1) {
                   cns = dp[tmpSrc] + curFee;
               } else {
                   cns = Math.min(cns, dp[tmpSrc] + curFee);
               }
            }
            for (int i = 0; i < cur[1].size(); i++) {
                int tmpDst = cur[1].get(i);
                if (!visited.contains(tmpDst) && tmpDst != dst) {
                    dp[tmpDst] = dp[indx] + cur[2].get(i);
                    if (grah.get(tmpDst) != null) {
                        queue.offer(grah.get(tmpDst));
                        qIndex.offer(tmpDst);
                    }
                }
            }
            queue.offer(null);
        }
        return cns;
    }
}
