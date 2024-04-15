package com.algorithm.leetcode;

import java.util.Arrays;

class Solution3085 {
    public static void main(String[] args) {
        Solution3085 s = new Solution3085();
        String word = "aabcaba";
        int k = 0;
        System.out.println(s.minimumDeletions(word, k));

        String word1 = "dabdcbdcdcd";
        int k1 = 2;
        System.out.println(s.minimumDeletions(word1, k1));

        String word2 = "aaabaaa";
        int k2 = 2;
        System.out.println(s.minimumDeletions(word2, k2));
    }
    public int minimumDeletions(String word, int k) {
        int[] cnts = new int[26];
        for (char c: word.toCharArray()) {
            int ind = (int)c - (int)'a';
            cnts[ind] += 1;
        }
        Arrays.sort(cnts);
        int i = 0;
        while (cnts[i] == 0) {
            i++;
        }
        if (i == 25) {
            return 0;
        }
        int[] res = new int[] {Integer.MAX_VALUE};
        dfsHelper(cnts, i, i + 1, 0, res, k, false);
        return res[0];
    }

    public void dfsHelper(int[] cnts, int i, int j, int maxV, int[] res, int k, boolean hasBase) {
        if (maxV > res[0]) {
            return;
        }
        if (j > 25) {
            res[0] = Math.min(res[0], maxV);
            return;
        }
        if (!hasBase) {
            dfsHelper(cnts, i + 1, j + 1, maxV + cnts[i], res, k, false);
        }
        int base = cnts[i] + k;
        int baseJ = cnts[j];
        dfsHelper(cnts, i, j + 1, baseJ > base ? maxV  + baseJ - base : maxV, res, k, true);
    }
}
