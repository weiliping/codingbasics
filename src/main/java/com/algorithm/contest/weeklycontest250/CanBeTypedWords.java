package com.algorithm.contest.weeklycontest250;

public class CanBeTypedWords {
    public static void main(String[] args) {
        CanBeTypedWords c = new CanBeTypedWords();
        String text1 = "hello world", brokenLetters1 = "ad";
        System.out.println(c.canBeTypedWords(text1, brokenLetters1));

        String text2 = "leet code", brokenLetters2 = "lt";
        System.out.println(c.canBeTypedWords(text2, brokenLetters2));

        String text3 = "leet code", brokenLetters3 = "e";
        System.out.println(c.canBeTypedWords(text3, brokenLetters3));
    }

    public int canBeTypedWords(String text, String brokenLetters) {
        String[] strs = text.split(" ");
        int n = strs.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] chrs = strs[i].toCharArray();
            boolean canInput = true;
            for (int j = 0; j < chrs.length; j++) {
                if (brokenLetters.indexOf(chrs[j]) > -1) {
                    canInput = false;
                    break;
                }
            }
            if (canInput) {
                cnt++;
            }
        }
        return cnt;
    }
}
