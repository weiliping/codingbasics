package com.algorithm.contest.weeklycontest298;

public class GreatestLetter {
    public static void main(String[] args) {
        System.out.println(greatestLetter("lEeTcOdE"));
        System.out.println(greatestLetter("arRAzFif"));
        System.out.println(greatestLetter("AbCdEfGhIjK"));
    }

    public static String greatestLetter(String s) {
        boolean[] upcases = new boolean[26];
        boolean[] lowcases = new boolean[26];
        char[] chs = s.toCharArray();
        for (char c : chs) {
            int ind = c - 'a';
            if (ind < 0) {
                upcases[c - 'A'] = true;
            } else {
                lowcases[ind] = true;
            }
        }

        for (int i = 25; i > -1; i--) {
            if (upcases[i] && lowcases[i]) {
                return String.valueOf((char)('A' + i));
            }
        }
        return "";
    }
}
