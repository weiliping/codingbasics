package com.algorithm.strings;

import java.util.Stack;

public class ReverseWords {

    /**
     * #151
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("  hello world!  "));
        System.out.println(reverseWords(" 1"));
        System.out.println("[" + reverseWords("   a   b ") + "]");
        System.out.println("[" + reverseWordsII("   a   b ") + "]");
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int l = 0, r = s.length() - 1;
        Stack<String> q = new Stack<>();
        while (l < r && (s.charAt(l) == ' ' || s.charAt(r) == ' ')) {
            if (s.charAt(l) == ' ') {
                l++;
            }
            if (s.charAt(r) == ' ') {
                r--;
            }
        }

        if (l == r) {
            String res = s.substring(l, l + 1);
            return " ".equals(res) ? "" : res;
        }

        while (l < r) {
            int j = l;
            while (j <= r && s.charAt(j) != ' ') {
                j++;
            }
            q.push(s.substring(l, j));
            while (j <= r && s.charAt(j) == ' ') {
                j++;
            }
            l = j;
        }
        if (l == r && s.charAt(r) != ' ') {
            q.push(s.substring(r, r + 1));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            String word = q.pop();
            sb.append(word);
            if (!q.isEmpty()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String reverseWordsII(String s) {
        String[] words = s.trim().split("\\s+");
        int l = 0, r = words.length - 1;
        while (l < r) {
            String tmp = words[l];
            words[l] = words[r];
            words[r] = tmp;
            l++;
            r--;
        }
        return String.join(" ", words);
    }
}
