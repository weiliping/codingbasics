package com.algorithm.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution3102 {
    public int minimumDistance(int[][] points) {
        /**
         * # 曼哈顿距离去绝对值
         * 1. x1 >= x2, y1 >= y2
         * # |x1 - x2| + |y1 - y2| = (x1 + y1) - (x2 + y2)
         * # 2. x1 < x2, y1 < y2
         * # |x1 - x2| + |y1 - y2| = (x2 + y2) - (x1 + y1)
         * # 3. x1 < x2, y1 >= y2
         * # |x1 - x2| + |y1 - y2| = (x2 - y2) - (x1 - y1)
         * 
         * # 4. x1 >= x2, y1 < y2
         * # |x1 - x2| + |y1 - y2| = (x1 - y1) - (x2 - y2)
         * # 易知，最大曼哈顿距离为：
         * #   1. max(x + y) - min(x + y)
         * #   2. max(x - y) - min(x - y)
         * # 二者最大值，即
         * # max(max(x + y) - min(x + y), max(x - y) - min(x - y))
         */
        TreeMap<Integer, Integer> st1 = new TreeMap<>();
        TreeMap<Integer, Integer> st2 = new TreeMap<>();
        for (int[] point: points) {
            int k1 = point[0] + point[1];
            int k2 = point[0] - point[1];  
            st1.put(k1, st1.getOrDefault(k1, 0) + 1);
            st1.put(k2, st2.getOrDefault(k2, 0) + 1);
            
        }
        int res = Integer.MAX_VALUE;
        for (int[] point: points) {
            int k1 = point[0] + point[1];
            int k2 = point[0] - point[1];
            if (st1.get(k1) == 1) {
                st1.remove(k1);
            } else {
                st1.put(k1, st1.get(k1) - 1);
            }
            if (st2.get(k2) == 1) {
                st2.remove(k2);
            } else {
                st2.put(k2, st2.get(k2) - 1);
            }
            res = Math.min(res, Math.max(st1.lastKey() - st1.firstKey(), st2.lastKey() - st2.firstKey()));
            st1.put(k1, st1.getOrDefault(k1, 0) + 1);
            st1.put(k2, st2.getOrDefault(k2, 0) + 1);
        }
        return res;
    }    
}

