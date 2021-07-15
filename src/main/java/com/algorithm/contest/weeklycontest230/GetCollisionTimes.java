package com.algorithm.contest.weeklycontest230;

import java.util.Arrays;

public class GetCollisionTimes {

    public static void main(String[] args) {
//        int[][] cars1 = new int[][] {{1,2}, {2,1}, {4,3}, {7,2}};
//        System.out.println(Arrays.toString(getCollisionTimes(cars1)));
        int[][] cars2 = new int[][] {{3,4}, {5,4}, {6,3}, {9,1}};
        System.out.println(Arrays.toString(getCollisionTimes(cars2)));
    }

    public static double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] res = new double[n];
        res[n - 1] = -1.0;
        for (int i = 0; i < n - 1; i++) {
            double r = -1.0;
            int[] curr = cars[i];
            for (int j = i + 1; j < n; j++) {
                int[] next = cars[j];
                if (next[1] >= curr[1]) {
                    continue;
                }
                double sutTime = (double) (next[0] - curr[0]) / (curr[1] - next[1]);
                if (r == -1.0 || r > sutTime) {
                    r = sutTime;
                }
            }
            res[i] = r;
        }
        return res;
    }
}
