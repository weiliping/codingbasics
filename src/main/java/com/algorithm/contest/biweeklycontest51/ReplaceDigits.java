package com.algorithm.contest.biweeklycontest51;

public class ReplaceDigits {
    public static void main(String[] args) {
        ReplaceDigits r = new ReplaceDigits();
        System.out.println(r.replaceDigits("a1c1e1"));
        System.out.println(r.replaceDigits("a1b2c3d4e"));
    }
    public String replaceDigits(String s) {
        char[] chrs = s.toCharArray();
        int n = chrs.length;

        for (int i = 1; i < n; i += 2) {
            chrs[i] = shift(chrs[i - 1], chrs[i]);
        }
        return new String(chrs);
    }

    static char shift(char a, char b) {
        return (char) (a + (b - '0'));
    }
}
