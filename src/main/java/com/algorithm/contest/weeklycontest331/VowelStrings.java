package com.algorithm.contest.weeklycontest331;

public class VowelStrings {
    public static void main(String[] args) {

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i];
            if (isVowel(words[i].charAt(0)) && isVowel(words[i].charAt(words[i].length() - 1))) {
                sum[i + 1]++;
            }
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int[] inds = queries[i];
            res[i] = sum[inds[1] + 1] - sum[inds[0]];
        }
        return res;
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
}
