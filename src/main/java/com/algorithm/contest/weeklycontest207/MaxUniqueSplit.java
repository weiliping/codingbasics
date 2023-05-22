package com.algorithm.contest.weeklycontest207;

import java.util.HashSet;
import java.util.Set;

public class MaxUniqueSplit {

    public static void main(String[] args) {
        String s = "ababccc";
        MaxUniqueSplit m = new MaxUniqueSplit();
//        System.out.println(m.maxUniqueSplit(s));
        System.out.println(m.maxUniqueSplit("wwwzfvedwfvhsww"));
//        System.out.println(m.maxUniqueSplit("aa"));
    }
    public int maxUniqueSplit(String s) {
        int[] res = new int[1];
        dfs(0, 0, res, s, new HashSet<>());
        return res[0];
    }

    void dfs(int index, int split, int[] res, String s, Set<String> set) {
        int len = s.length();
        if (index >= len) {
            if (res[0] < split) {
                res[0] = split;
            }
            return;
        }
        for (int i = index; i < len; i++) {
            String str = s.substring(index, i + 1);
            if (set.add(str)) {
                dfs(i + 1, split + 1, res, s, set);
                set.remove(str);
            }
        }
    }
    public int maxUniqueSplitII(String s) {
        Set<String> m = new HashSet<>();
        int i = 0, j = 1, n = s.length();
        while (j <= n) {
            String sub = s.substring(i, j);
            if (m.contains(sub)) {
                j++;
                continue;
            }
            m.add(sub);
            i = j;
            j++;
        }
        return m.size();
    }

}
