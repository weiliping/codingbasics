package com.algorithm.contest.biweeklycontest53;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubstrings {
    public static void main(String[] args) {
        CountGoodSubstrings c = new CountGoodSubstrings();
        System.out.println(c.countGoodSubstrings("xyzzaz"));
        System.out.println(c.countGoodSubstrings("aababcabc"));
    }
    public int countGoodSubstrings(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        char[] chrs = s.toCharArray();
        int n = chrs.length, cnt = 0;

        for(int j = 0; j < n; j++) {
            if (j <= 2) {
                mp.put(chrs[j], mp.getOrDefault(chrs[j], 0) + 1);
                continue;
            }
            if (mp.size() == 3) {
                cnt++;
            }
            int v = mp.get(chrs[j - 3]) - 1;
            if (v == 0) {
                mp.remove(chrs[j - 3]);
            } else {
                mp.put(chrs[j - 3], v);
            }
            mp.put(chrs[j], mp.getOrDefault(chrs[j], 0) + 1);
        }
        return mp.size() == 3 ? cnt + 1 : cnt;
    }
}
