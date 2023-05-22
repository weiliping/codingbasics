package com.algorithm.math;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {

    /**
     * #149
     * https://leetcode-cn.com/problems/max-points-on-a-line/
     * @param args
     */
    public static void main(String[] args) {
        int[][] points = new int[][] { { 1, 1 }, { 3, 2 }, { 5, 3 }, { 4, 1 }, { 2, 3 }, { 1, 4 } };
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int res = 0, len = points.length;
        for (int i = 0; i < len; i++) {
            Map<Map<Integer, Integer>, Integer> store = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < len; j++) {
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicate++;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                Map<Integer, Integer> t = new HashMap<>();
                t.put(dx / d, dy / d);
                store.put(t, store.getOrDefault(t, 0) + 1);
            }
            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : store.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
