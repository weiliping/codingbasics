package com.algorithm.contest.weeklycontest308;

import java.util.Arrays;

public class RemoveStars {
    public static void main(String[] args) {
        // System.out.println(removeStars("leet**cod*e"));
        System.out.println(removeStars("erase*****"));
    }

    public static String removeStars(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length, i = 0, j = 0;
        while (j < n) {
            if (chrs[j] == '*') {
                i--;
            } else {
                if (i != j) {
                    chrs[i] = chrs[j];
                }
                i++;
            }
            j++;
        }
        return String.valueOf(Arrays.copyOfRange(chrs, 0, i));
    }
}
