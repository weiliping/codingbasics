package com.algorithm.strings;

import java.util.Stack;

public class ValidParentheses {
    /**
     * #20
     * https://leetcode-cn.com/problems/valid-parentheses/
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("()"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                Character left = st.pop();
                if ((left == '[' && c != ']') || (left == '{' && c != '}') || (left == '(' && c != ')')) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
}
