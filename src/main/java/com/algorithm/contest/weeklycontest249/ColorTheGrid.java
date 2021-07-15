package com.algorithm.contest.weeklycontest249;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ColorTheGrid {
    public static void main(String[] args) {
        ColorTheGrid c = new ColorTheGrid();
//        System.out.println(c.colorTheGrid(1, 1));
//        System.out.println(c.colorTheGrid(1, 2));
        System.out.println(c.colorTheGrid(5, 5));
    }

    static final int MOD = (int) 1e9 + 7;
    public int colorTheGrid(int m, int n) {
        int len = power(m);
        Map<Integer, List<Integer>> valid = new HashMap<>();
        for (int i = 0; i < len; i++) {
            List<Integer> v = new ArrayList<>();
            int k = i;
            for (int j = 0; j < m; j++) {
                v.add(k % 3);
                k /= 3;
            }

            boolean check = true;
            for (int j = 0; j < m - 1; j++) {
                if (v.get(j) == v.get(j + 1)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                valid.put(i, v);
            }
        }
        Map<Integer, List<Integer>> adjacent = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> a : valid.entrySet()) {
            for (Map.Entry<Integer, List<Integer>> b : valid.entrySet()) {
                boolean check = true;
                for (int i = 0; i < m; i++) {
                    if (a.getValue().get(i) == b.getValue().get(i)) {
                        check = false;
                        break;
                    }
                }

                if (check) {
                    List<Integer> l = adjacent.getOrDefault(a.getKey(), new ArrayList<>());
                    l.add(b.getKey());
                    adjacent.put(a.getKey(), l);
                }
            }
        }

        int[] f = new int[len];
        for (int i : valid.keySet()) {
            f[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int[] g = new int[len];
            for (int j : valid.keySet()) {
                for (int k : adjacent.get(j)) {
                    g[j] += f[k];
                    if (g[j] >= MOD) {
                        g[j] -= MOD;
                    }
                }
            }
            f = g;
        }
        int cnt = 0;
        for (int v : f) {
            cnt += v;
            if (cnt >= MOD) {
                cnt -= MOD;
            }
        }
        return cnt;
    }

    static int power(int m) {
        int p = 1;
        while (m > 0) {
            p *= 3;
            m--;
        }
        return p;
    }
}
