package com.algorithm.contest.weeklycontest190;

import java.util.HashSet;
import java.util.Set;

public class MaxVowels {

    public static void main(String[] args) {
        MaxVowels m = new MaxVowels();
        System.out.println(m.maxVowels("abciiidef", 3));
        System.out.println(m.maxVowels("aeiou", 2));
        System.out.println(m.maxVowels("leetcode", 3));
        System.out.println(m.maxVowels("rhythms", 4));
        System.out.println(m.maxVowels("tryhard", 4));
    }
    static final Set<Character> VOWELS = new HashSet<>();
    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
    }

    public int maxVowels(String s, int k) {
        char[] chrs = s.toCharArray();
        int res = 0, cnt = 0, n = chrs.length;
        for (int i = 0; i < n; i++) {
            if (VOWELS.contains(chrs[i])) {
                cnt++;
            }
            if (i < k - 1) {
                continue;
            }
            if (i > k - 1 && VOWELS.contains(chrs[i - k])) {
                cnt--;
            }
            if (res < cnt) {
                res = cnt;
            }
        }
        return res;
    }
}
