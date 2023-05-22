package com.algorithm.contest.weeklycontest259;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    public static void main(String[] args) {
        DetectSquares d = new DetectSquares();
        d.add(new int[] { 3, 10 });
        d.add(new int[] { 11, 2 });
        d.add(new int[] { 3, 2 });
        System.out.println(d.count(new int[] { 11, 10 }));
        System.out.println(d.count(new int[] { 14, 8 }));
        d.add(new int[] { 11, 2 });
        System.out.println(d.count(new int[] { 11, 10 }));
    }

    Map<Integer, Map<Integer, Integer>> xPoints;
    Map<Integer, Map<Integer, Integer>> yPoints;

    public DetectSquares() {
        xPoints = new HashMap<>();
        yPoints = new HashMap<>();
    }

    public void add(int[] point) {
        Map<Integer, Integer> xInds = xPoints.getOrDefault(point[0], new HashMap<>());
        xInds.put(point[1], xInds.getOrDefault(point[1], 0) + 1);
        xPoints.put(point[0], xInds);
        Map<Integer, Integer> yInds = yPoints.getOrDefault(point[1], new HashMap<>());
        yInds.put(point[0], yInds.getOrDefault(point[0], 0) + 1);
        yPoints.put(point[1], yInds);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];

        Map<Integer, Integer> xInds = xPoints.get(x);
        if (xInds == null) {
            return 0;
        }

        Map<Integer, Integer> yInds = yPoints.get(y);

        if (yInds == null) {
            return 0;
        }
        int cnt = 0;
        for (int y1 : xInds.keySet()) {
            int diff = Math.abs(y - y1);
            if (diff == 0) {
                continue;
            }
            for (int x1 : yInds.keySet()) {
                if (diff == Math.abs(x - x1)) {
                    int v1 = xInds.get(y1), v2 = yInds.get(x1);
                    Map<Integer, Integer> y1Inds = xPoints.get(x1);
                    if (y1Inds != null && y1Inds.keySet().contains(y1)) {
                        cnt += v1 * v2 * y1Inds.get(y1);
                    }
                }
            }
        }
        return cnt;
    }
}
