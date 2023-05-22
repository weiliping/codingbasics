package com.algorithm.contest.weeklycontest229;

public class MergeAlternately {
    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab","pqrs"));
    }
    public static String mergeAlternately(String word1, String word2) {
        int i = 0, n = word1.length(), j = 0, m = word2.length();
        char[] chrs = new char[m + n];
        int k = 0;
        while (i < n && j < m) {
            chrs[k++] = word1.charAt(i++);
            chrs[k++] = word2.charAt(j++);
        }

        while (i < n) {
            chrs[k++] = word1.charAt(i++);
        }

        while (j < m) {
            chrs[k++] = word2.charAt(j++);
        }

        return new String(chrs);
    }
}
