package com.algorithm.contest.weeklycontest218;

import java.util.HashMap;
import java.util.Map;

public class MaxOperations {

    public static void main(String[] args) {
        MaxOperations m = new MaxOperations();
        System.out.println(m.maxOperations(new int[] { 1, 2, 3, 4 }, 5));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        for (int num : nums) {
            int l = k - num;
            if (mp.containsKey(l)) {
                cnt++;
                int v = mp.get(l) - 1;
                if (v == 0) {
                    mp.remove(l);
                } else {
                    mp.put(l, v);
                }
                continue;
            }
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        return cnt;
    }
}
