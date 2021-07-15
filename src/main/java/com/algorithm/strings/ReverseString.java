package com.algorithm.strings;

import java.util.Arrays;

public class ReverseString {

    /**
     * https://leetcode-cn.com/problems/reverse-string
     *
     * @param args
     */
    public static void main(String[] args) {
        char[] s =
                new char[] { 'A', ' ', 'm', 'a', 'n', ',', ' ', 'a', ' ', 'p', 'l', 'a', 'n', ',', ' ', 'a', ' ', 'c',
                        'a', 'n', 'a', 'l', ':', ' ', 'P', 'a', 'n', 'a', 'm', 'a' };
        new ReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int l = s.length - 1;
        for (int i = 0; i <= l / 2; i++) {
            char tmp = s[i];
            s[i] = s[l - i];
            s[l - i] = tmp;
        }
    }
}
