package com.algorithm.contest.weeklycontest211;

import java.util.HashMap;
import java.util.Map;

public class MaxLengthBetweenEqualCharacters {

    public static void main(String[] args) {
        MaxLengthBetweenEqualCharacters m = new MaxLengthBetweenEqualCharacters();
        System.out.println(m.maxLengthBetweenEqualCharacters("aa"));
        System.out.println(m.maxLengthBetweenEqualCharacters("abca"));
        System.out.println(m.maxLengthBetweenEqualCharacters("cbzxy"));
        System.out.println(m.maxLengthBetweenEqualCharacters("cabbac"));
    }
    public int maxLengthBetweenEqualCharacters(String s) {
        char[] chrs = s.toCharArray();
        Map<Character, Integer> h = new HashMap<>();
        int cnt = -1;
        for (int i = 0; i < chrs.length; i++) {
            if (h.containsKey(chrs[i])) {
                int t = i - h.get(chrs[i]) - 1;
                if (cnt < t) {
                    cnt = t;
                }
                continue;
            }
            h.put(chrs[i], i);
        }
        return cnt;
    }
}
