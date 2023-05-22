package com.algorithm.contest.weeklycontest317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCreator {
    public static void main(String[] args) {
        String creators[] = new String[] { "alice", "bob", "alice", "chris" },
                ids[] = new String[] { "one", "two", "three", "four" };
        int views[] = new int[] { 5, 10, 5, 4 };
        List<List<String>> res = mostPopularCreator(creators, ids, views);
        for (List<String> r : res) {
            System.out.println(r);
        }
    }

    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, int[]> sumMap = new HashMap<>();
        int n = creators.length;
        for (int i = 0; i < n; i++) {
            if (sumMap.containsKey(creators[i])) {
                int[] cnts = sumMap.get(creators[i]);
                cnts[0] += views[i];
                if (cnts[1] < views[i]) {
                    cnts[1] = views[i];
                    cnts[2] = i;
                } else if (cnts[1] == views[i]) {
                    if (ids[cnts[2]].compareTo(ids[i]) > -1) {
                        cnts[2] = i;
                    }
                }
                continue;
            }
            int[] cnts = new int[3];
            cnts[0] += views[i];
            cnts[1] = views[i];
            cnts[2] = i;
            sumMap.put(creators[i], cnts);
        }
        int max = Integer.MIN_VALUE;
        for (int[] v : sumMap.values()) {
            if (max < v[0]) {
                max = v[0];
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, int[]> m : sumMap.entrySet()) {
            if (m.getValue()[0] == max) {
                res.add(Arrays.asList(m.getKey(), ids[m.getValue()[2]]));
            }
        }
        return res;
    }
}
