package com.algorithm.contest.weeklycontest272;

import java.util.Arrays;

public class AddSpaces {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        Arrays.sort(spaces);
        for (int i = 0; i < n; i++) {
            if (Arrays.binarySearch(spaces, i) >= 0) {
                sb.append(' ');
            }
            sb.append(chrs[i]);
        }

        return sb.toString();
    }

}
