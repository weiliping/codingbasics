package com.algorithm.contest.weeklycontest244;

import java.util.Map;
import java.util.TreeMap;

public class ReductionOperations {

    public static void main(String[] args) {
        ReductionOperations r = new ReductionOperations();
        System.out.println(r.reductionOperations(new int[]{5,1,3}));
        System.out.println(r.reductionOperations(new int[]{1, 1, 1}));
        System.out.println(r.reductionOperations(new int[]{1,1,2,2,3}));
        System.out.println(r.reductionOperations(new int[] { 7, 9, 10, 8, 6, 4, 1, 5, 2, 3 }));
    }
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for (int i : nums) {
            tree.put(i, tree.getOrDefault(i, 0) + 1);
        }
        int cnt = 0;
        while (tree.size() > 1) {
            Map.Entry<Integer, Integer> v = tree.pollLastEntry();
            int preKey = tree.lowerKey(v.getKey());
            tree.put(preKey, tree.get(preKey) + v.getValue());
            cnt += v.getValue();
        }
        return cnt;
    }
}
