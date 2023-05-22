package com.algorithm.contest.weeklycontest168;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MaxFreq {
    public static void main(String[] args) {
        MaxFreq m = new MaxFreq();
        String s = "aababcaab";
        Integer maxLetters = 2, minSize = 3, maxSize = 4;
        System.out.println(m.maxFreq(s, maxLetters, minSize, maxSize));
        System.out.println(m.maxFreqI(s, maxLetters, minSize, maxSize));

        String s1 = "aaaa";
        Integer maxLetters1 = 1, minSize1 = 3, maxSize1 = 3;
        System.out.println(m.maxFreq(s1, maxLetters1, minSize1, maxSize1));
        System.out.println(m.maxFreqI(s1, maxLetters1, minSize1, maxSize1));

        String s2 = "aabcabcab";
        Integer maxLetters2 = 2, minSize2 = 2, maxSize2 = 3;
        System.out.println(m.maxFreq(s2, maxLetters2, minSize2, maxSize2));
        System.out.println(m.maxFreqI(s2, maxLetters2, minSize2, maxSize2));

        String s3 = "abcde";
        Integer maxLetters3 = 2, minSize3 = 3, maxSize3 = 3;
        System.out.println(m.maxFreq(s3, maxLetters3, minSize3, maxSize3));
        System.out.println(m.maxFreqI(s3, maxLetters3, minSize3, maxSize3));

        String s4 = args[0];
        Integer maxLetters4 = 3, minSize4 = 5, maxSize4 = 26;
        System.out.println(m.maxFreq(s4, maxLetters4, minSize4, maxSize4));
        System.out.println(m.maxFreqI(s4, maxLetters4, minSize4, maxSize4));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chrs = s.toCharArray();
        int cnt = Integer.MIN_VALUE, n = chrs.length;

        Set<String> set = new HashSet<>();
        for (int len = minSize; len <= maxSize; len++) {
            int[] cnts = new int[26];
            Map<String, Integer> mp = new HashMap<>();
            for (int i = 0; i < len; i++) {
                cnts[chrs[i] - 'a']++;
            }
            if (countLetter(cnts) <= maxLetters) {
                String key = s.substring(0, len);
                if (!set.contains(key.substring(0, minSize))) {
                    mp.put(key, mp.getOrDefault(key, 0) + 1);
                }
            }
            for (int i = len; i < n; i++) {
                cnts[chrs[i - len] - 'a']--;
                cnts[chrs[i] - 'a']++;
                if (countLetter(cnts) <= maxLetters) {
                    String key = s.substring(i - len + 1, i + 1);
                    if (!set.contains(key.substring(0, minSize))) {
                        mp.put(key, mp.getOrDefault(key, 0) + 1);
                    }
                }
            }
            for (Map.Entry<String, Integer> e : mp.entrySet()) {
                set.add(e.getKey());
                cnt = Math.max(cnt, e.getValue());
            }
        }

        return cnt == Integer.MIN_VALUE ? 0 : cnt;
    }

    static int countLetter(int[] chrs) {
        int c = 0;
        for (int i = 0; i < 26; i++) {
            if (chrs[i] != 0) {
                c++;
            }
        }
        return c;
    }

    public int maxFreqI(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<String, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        int[] cnt = new int[26];
        int letter = 0;
        int l = 0, r = 0;
        while (r < ch.length) {
            if (++cnt[ch[r++] - 'a'] == 1) {
                letter++;
            }
            while (letter > maxLetters) {
                if (--cnt[ch[l++] - 'a'] == 0) {
                    letter--;
                }
            }
            if (r - l >= minSize) {
                String cur = s.substring(r - minSize, r);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
        int res = 0;
        for (int v : map.values()) {
            res = Math.max(res, v);
        }
        return res;
    }
}
