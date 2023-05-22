package com.algorithm.contest.weeklycontest222;

import java.util.Map;
import java.util.TreeMap;

public class MaximumUnits {
    public static void main(String[] args) {
        int[][] boxTypes = new int[][] {{1,3}, {2,2}, {3,1}};

        int truckSize = 4;
        System.out.println(maximumUnits(boxTypes, truckSize));

        int[][] boxTypes1 = new int[][] {{5,10}, {2,5}, {4,7}, {3,9}};
        System.out.println(maximumUnits(boxTypes1, 10));
    }
    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] type : boxTypes) {
            map.put(type[1], map.getOrDefault(type[1], 0) + type[0]);
        }

        int res = 0;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> m = map.pollLastEntry();

            if (truckSize >= m.getValue()) {
                res += m.getKey() * m.getValue();
                truckSize -= m.getValue();
                continue;
            }
            res += m.getKey() * truckSize;
            truckSize = 0;
        }
        return res;
    }
}
