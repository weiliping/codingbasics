package com.algorithm.contest.weeklycontest266;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountVowels {

    static final Set<Character> sets = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static void main(String[] args) {
        System.out.println(countVowels("noosabasboosa"));
//        System.out.println(countVowels("aba"));
//        System.out.println(countVowels("abc"));
//        System.out.println(countVowels("ltcd"));
    }

    public static long countVowels(String word) {
        long cnt = 0l;
        char[] chrs = word.toCharArray();
        int n = chrs.length;
        for (int i = 0; i < n; i++) {
            if (sets.contains(chrs[i])) {
                cnt += (i + 1) * (n - i);
            }
        }
        return cnt;
    }
}
