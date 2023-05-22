package com.algorithm.contest.weeklycontest221;

import java.util.HashSet;
import java.util.Set;

public class HalvesAreAlike {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlikeI("textbook"));
    }
    static Set<Character> chrs = new HashSet<>();
    static {
        chrs.add('a');
        chrs.add('e');
        chrs.add('i');
        chrs.add('o');
        chrs.add('u');
        chrs.add('A');
        chrs.add('E');
        chrs.add('I');
        chrs.add('O');
        chrs.add('U');
    }
    public static boolean halvesAreAlike(String s) {
        int n = s.length(), i = n/2, j = i - 1, cnta = 0, cntb = 0;
        while (j >= 0 && i < n) {
            if (chrs.contains(s.charAt(j))) {
                cnta++;
            }
            j--;

            if (chrs.contains(s.charAt(i))) {
                cntb++;
            }
            i++;
        }
        return cnta == cntb;
    }

    public static boolean halvesAreAlikeI(String s) {
        int[] cnts = new int[128];
        cnts['a'] = 1;
        cnts['e'] = 1;
        cnts['i'] = 1;
        cnts['o'] = 1;
        cnts['u'] = 1;
        cnts['A'] = 1;
        cnts['E'] = 1;
        cnts['I'] = 1;
        cnts['O'] = 1;
        cnts['U'] = 1;
        int l = 0, r = s.length() - 1, cnt = 0;
        while (l < r) {
            cnt += cnts[s.charAt(++l)];
            cnt -= cnts[s.charAt(--r)];
        }
        return cnt == 0;
    }
}
