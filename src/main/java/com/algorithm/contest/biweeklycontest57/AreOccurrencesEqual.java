package com.algorithm.contest.biweeklycontest57;

import java.util.Arrays;

public class AreOccurrencesEqual {

    public static void main(String[] args) {
        AreOccurrencesEqual a = new AreOccurrencesEqual();
        System.out.println(a.areOccurrencesEqual("abacbc"));
        System.out.println(a.areOccurrencesEqual("aaabb"));
    }

    public boolean areOccurrencesEqual(String s) {
        int[] cnts = new int[26];
        char[] chrs = s.toCharArray();
        for (char c : chrs) {
            cnts[c - 'a']++;
        }
        Arrays.sort(cnts);
        int ct = cnts[25];
        for(int i = 24; i >= 0; i--) {
            if (cnts[i] == 0) {
                break;
            }
            if (ct != cnts[i]) {
                return false;
            }
        }
        return true;
    }
}