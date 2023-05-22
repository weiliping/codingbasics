package com.algorithm.contest.weeklycontest321;

public class AppendCharacters {

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
        System.out.println(appendCharacters("vrykt", "rkge"));
        System.out.println(appendCharacters("abcde", "a"));
        System.out.println(appendCharacters("z", "abcde"));
    }

    public static int appendCharacters(String s, String t) {
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        int n = cs.length, m = ct.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == ct[j]) {
                j++;
                if (j == m) {
                    return 0;
                }
            }
        }
        return m - j;
    }
}
