package com.algorithm.contest.weeklycontest215;

import java.util.Arrays;
import java.util.Comparator;

public class CloseStrings {
    public static void main(String[] args) {
        CloseStrings c = new CloseStrings();
        System.out.println(c.closeStrings("cabbba", "abbccc"));
    }
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n != m) {
            return false;
        }

        int[] chrs1 = new int[26], chrs2 = new int[26];

        for (char c : word1.toCharArray()) {
            chrs1[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            chrs2[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((chrs1[i] == 0 && chrs2[i] != 0) || (chrs1[i] != 0 && chrs2[i] == 0)) {
                return false;
            }
        }
        Arrays.sort(chrs1);
        Arrays.sort(chrs2);

        for (int i = 25; i >= 0; i--) {
            if (chrs1[i] == 0 && chrs2[i] == 0) {
                break;
            }
            if (chrs2[i] != chrs1[i]) {
                return false;
            }
        }
        return true;
    }
}
