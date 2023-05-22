package com.algorithm.contest.weeklycontest258;

import java.util.HashMap;
import java.util.Map;

public class InterchangeableRectangles {
    public static void main(String[] args) {
        System.out.println(gcd(56, 28));
    }
    public long interchangeableRectangles(int[][] rectangles) {
        int n = rectangles.length;
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] rec = rectangles[i];
            String key = toKey(rec);
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }
        long cns = 0l;

        for (int v : mp.values()) {
            if (v > 1) {
                cns += (((long)v * (v - 1)) >> 1);
            }
        }
        return cns;
    }

    static String toKey(int[] rec) {
        int g = gcd(rec[0], rec[1]);
        int n1 = rec[0] / g;
        int n2 = rec[1] / g;
        return n1 + "/" + n2;
    }

    static int gcd(int i, int j) {
        int t = i % j;
        if (t == 0) {
            return j;
        }
        return gcd(j, t);
    }
}
