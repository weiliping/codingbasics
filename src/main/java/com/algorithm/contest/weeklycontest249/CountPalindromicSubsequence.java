package com.algorithm.contest.weeklycontest249;

import java.util.Arrays;

public class CountPalindromicSubsequence {

    public static void main(String[] args) {
        CountPalindromicSubsequence c = new CountPalindromicSubsequence();
        System.out.println(c.countPalindromicSubsequence("aabca"));
        System.out.println(c.countPalindromicSubsequence("adc"));
        System.out.println(c.countPalindromicSubsequence("bbcbaba"));
    }

	public int countPalindromicSubsequence(String s) {
        int[][] cnts = new int[26][2];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(cnts[i], -1);
        }
        char[] chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            int ind = chrs[i] - 'a';
            if (cnts[ind][0] != -1) {
                cnts[ind][1] = i;
                continue;
            }
            cnts[ind][0] = i;
        }
        boolean[] mp = new boolean[26];
        int res = 0;
        for (int i = 0; i < 26; i++) {
            int[] inds = cnts[i];
            if (inds[1] == -1) {
                continue;
            }
            Arrays.fill(mp, false);
            int sub = 0;
            for (int j = inds[0] + 1; j < inds[1]; j++) {
                int chInd = chrs[j] - 'a';
                if (!mp[chInd]) {
                    mp[chInd] = true;
                    sub++;
                    if (sub == 26) {
                        break;
                    }
                }
            }
            res += sub;
        }
        return res;
    }
}