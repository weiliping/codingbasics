package com.algorithm.contest.weeklycontest224;

import java.util.HashMap;
import java.util.Map;

public class TupleSameProduct {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[] { 2, 3, 4, 6 }));
        System.out.println(tupleSameProduct(new int[] { 1, 2, 4, 5, 10 }));
        System.out.println(tupleSameProduct(new int[] { 2, 3, 4, 6, 8, 12 }));
        System.out.println(tupleSameProduct(new int[] { 2, 3, 5, 7 }));
    }

    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = nums[i] * nums[j];
                map.put(k, map.getOrDefault(k, 0) + 1);
            }
        }
        int cnt = 0;
        for (int v : map.values()) {
            if (v > 1) {
                cnt += v * (v - 1) / 2;
            }
        }
        return cnt * 8;
    }
}
