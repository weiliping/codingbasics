package com.algorithm.contest.weeklycontest175;

import java.util.Arrays;

public class MinSteps {
    public static void main(String[] args) {
        MinSteps m = new MinSteps();
        System.out.println(m.minSteps("bab", "aba"));
        System.out.println(m.minSteps("leetcode", "practice"));
        System.out.println(m.minSteps("anagram", "mangaar"));
        System.out.println(m.minSteps("xxyyzz", "xxyyzz"));
        System.out.println(m.minSteps("friend", "family"));
    }
    public int minSteps(String s, String t) {
        int[] chr = new int[26];
        char[] chs1 = s.toCharArray(), chs2 = t.toCharArray();
        int n = chs1.length;
        for (int i = 0; i < n; i++) {
            chr[chs1[i] - 'a']++;
            chr[chs2[i] - 'a']--;
        }

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (chr[i] > 0) {
                cnt += chr[i];
            }
        }
        return cnt;
    }
}
