package com.algorithm.contest.weeklycontest166;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {
    public static void main(String[] args) {
        List<List<Integer>> res = groupThePeople(new int[] {3,3,3,3,3,1,3});
        for (List<Integer> l : res) {
            System.out.println(Arrays.toString(l.toArray()));
        }

        List<List<Integer>> res2 = groupThePeople(new int[] {2,1,3,3,3,2});
        for (List<Integer> l : res2) {
            System.out.println(Arrays.toString(l.toArray()));
        }

    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>>  res = new ArrayList<>();
        Map<Integer, List<Integer>> mp = new HashMap<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            List<Integer> l = mp.getOrDefault(groupSizes[i], new ArrayList<>());
            l.add(i);
            if (l.size() == groupSizes[i]) {
                res.add(l);
                mp.remove(groupSizes[i]);
                continue;
            }
            mp.put(groupSizes[i], l);
        }
        return res;
    }
}
