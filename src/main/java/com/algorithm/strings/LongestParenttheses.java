package com.algorithm.strings;

import java.util.Stack;

public class LongestParenttheses {

    /**
     * #32
     * https://leetcode-cn.com/problems/longest-valid-parentheses/
     * @param args
     */
    public static void main(String[] args) {
        String s = "(((()))()()";
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        Stack stack = new Stack();
        int j = 0, longest = 0;
        char[] chars = s.toCharArray();

        while (j < chars.length) {
            if (chars[j] == '(') {
                stack.push(j);
            }

            if (chars[j] == ')') {
                if (!stack.empty() && chars[(Integer) stack.peek()] == '(') {
                    stack.pop();
                    int lens;
                    if (!stack.empty()) {
                        lens = j - (Integer) stack.peek();
                    } else {
                        lens = j + 1;
                    }
                    if (lens > longest) {
                        longest = lens;
                    }
                } else {
                    stack.push(j);
                }
            }
            j++;
        }
        return longest;
    }
}
