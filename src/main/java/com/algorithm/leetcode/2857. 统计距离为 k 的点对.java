package com.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2857 {
    
    public static void main(String[] args) {
        List<List<Integer>> coordinates = new ArrayList<>();
        int k = 0;
        coordinates.add(List.of(1, 3));
        coordinates.add(List.of(1, 3));
        coordinates.add(List.of(1, 3));
        coordinates.add(List.of(1, 3));
        coordinates.add(List.of(1, 3));
        Solution2857 solution2857 = new Solution2857();
        System.out.println(solution2857.countPairs(coordinates, k));
    }
    static final long M = 2000000;
    public int countPairs(List<List<Integer>> coordinates, int k) {
        Map<Long, Integer> mp = new HashMap<>();
        int ans = 0;
        for (List<Integer> co : coordinates) {
            Integer l = co.get(0), r = co.get(1);
            for (int i = 0; i < k + 1; i++) {
                Long k1 = M * (i ^ l) + ((k - i) ^ r);
                if (mp.containsKey(k1)) {
                    ans += mp.get(k1);
                }
            }
            Long k3 = M * l + r;
            mp.merge(k3, 1, Integer::sum);
        }
        return ans;
    }
}