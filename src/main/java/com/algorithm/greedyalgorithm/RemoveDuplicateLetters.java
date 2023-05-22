package com.algorithm.greedyalgorithm;

import java.util.Stack;

public class RemoveDuplicateLetters {
    /**
     * #316
     * https://leetcode-cn.com/problems/remove-duplicate-letters/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
        System.out.println(removeDuplicateLettersII("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[toIndex(c)]++;
        }
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            cnts[toIndex(s.charAt(i))]--;
            if (cnts[toIndex(s.charAt(i))] == 0) {
                break;
            }
        }
        return s.length() == 0 ?
                "" :
                s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }



    public static String removeDuplicateLettersII(String s) {
        int[] lastIndexes = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            lastIndexes[toIndex(s.charAt(i))] = i;
        }
        Stack<Character> q = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!q.contains(c)) {
                while (!q.isEmpty() && q.peek() > c && lastIndexes[toIndex(q.peek())] > i) {
                    q.pop();
                }
                q.push(c);
            }
        }

        StringBuilder sb = new StringBuilder(q.size());
        for (Character c : q) {
            sb.append(c);
        }
        return sb.toString();
    }

    static int toIndex(char c) {
        return c - 'a';
    }
}
