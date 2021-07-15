package com.algorithm.strings;

public class LengthOfLastWord {

    /**
     * #58
     * https://leetcode-cn.com/problems/length-of-last-word
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a "));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int l = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return l;
            }
            l++;
        }
        return l;
    }
}
