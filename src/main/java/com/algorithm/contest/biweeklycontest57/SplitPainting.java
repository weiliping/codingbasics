package com.algorithm.contest.biweeklycontest57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitPainting {

    public static void main(String[] args) {
        SplitPainting s = new SplitPainting();

        // int[][] segments3 = new int[][] {{1,4,5}, {4,7,7}, {1,7,9}};
        // List<List<Long>> res3 = s.splitPainting(segments3);
        // for (List<Long> r : res3) {
        // System.out.println(Arrays.toString(r.toArray()));
        // }
        System.out.println("=========================");
        int[][] segments2 = new int[][] { { 1, 7, 9 }, { 6, 8, 15 }, { 8, 10, 7 } };
        List<List<Long>> res2 = s.splitPainting(segments2);
        for (List<Long> r : res2) {
            System.out.println(Arrays.toString(r.toArray()));
        }
        System.out.println("=========================");
        // int[][] segments1 = new int[][] {{1,4,5}, {1,4,7}, {4,7,1}, {4,7,11}};
        // List<List<Long>> res = s.splitPainting(segments1);
        // for (List<Long> r : res) {
        // System.out.println(Arrays.toString(r.toArray()));
        // }
    }

    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Integer, Long> map = new HashMap<>();
        for (int[] s : segments) {
            long v = map.getOrDefault(s[0], 0l);
            map.put(s[0], v + s[2]);

            long v2 = map.getOrDefault(s[1], 0l);
            map.put(s[1], v2 - s[2]);
        }

        List<Pair> q = new ArrayList<>();
        for (Map.Entry<Integer, Long> m : map.entrySet()) {
            q.add(new Pair(m.getKey(), m.getValue()));
        }
        q.sort(Comparator.comparingInt(a -> a.k));
        int n = q.size();
        for (int i = 1; i < n; i++) {
            Pair p = q.get(i), pre = q.get(i - 1);
            p.v += pre.v;
            q.set(i, p);
        }
        List<List<Long>> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            Pair cur = q.get(i);
            if (cur.v != 0) {
                List<Long> sub = new ArrayList<>();
                sub.add((long) cur.k);
                sub.add((long) q.get(i + 1).k);
                sub.add(cur.v);
                res.add(sub);
            }
        }
        return res;
    }

    class Pair {
        int k;
        long v;

        public Pair(int k, long v) {
            this.k = k;
            this.v = v;
        }
    }
}
