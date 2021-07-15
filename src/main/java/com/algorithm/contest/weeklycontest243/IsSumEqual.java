package com.algorithm.contest.weeklycontest243;

public class IsSumEqual {
    public static void main(String[] args) {
        IsSumEqual i = new IsSumEqual();
        System.out.println(i.isSumEqual("acb", "cba", "cdb"));
        System.out.println(i.isSumEqual("aaa", "a", "aaaa"));
        System.out.println(i.isSumEqual("aaa", "a", "aab"));
    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int sum = 0;
        sum += toInt(firstWord);
        sum += toInt(secondWord);
        return sum == toInt(targetWord);
    }

    static Integer toInt(String str) {
        char[] chrs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chrs) {
            sb.append((int)(c - 'a'));
        }

        return Integer.parseInt(sb.toString());
    }
}
