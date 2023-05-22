package com.algorithm.contest.weeklycontest189;

import java.util.Arrays;

public class ArrangeWords {

    public static void main(String[] args) {
        ArrangeWords a = new ArrangeWords();
        System.out.println(a.arrangeWords("Leetcode is cool"));
        System.out.println(a.arrangeWords("Keep calm and code on"));
        System.out.println(a.arrangeWords("To be or not to be"));
    }
    public String arrangeWords(String text) {
        text = Character.toLowerCase(text.charAt(0)) + text.substring(1);
        String[] strs = text.split(" ");
        int n = strs.length;
        int[][] inds = new int[n][2];

        for (int i = 0; i < n; i++) {
            inds[i] = new int[] {strs[i].length(), i};
        }

        Arrays.sort(inds, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        StringBuilder sb = new StringBuilder();

        for (int[] ind : inds) {
            sb.append(strs[ind[1]]);
            sb.append(" ");
        }

        sb.setLength(sb.length() - 1);
        return Character.toUpperCase(sb.charAt(0)) + sb.substring(1);
    }
}
