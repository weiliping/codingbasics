package com.algorithm.others;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Fib {

    long fib(int n) {
        long[] r = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i < 2) {
                r[i] = i;
            } else {
                r[i] = r[i - 1] + r[i - 2];
            }
        }
        return r[n];
    }

    long recursion(int n) {
        if (n < 2) {
            return n;
        }

        return recursion(n - 1) + recursion(n - 2);
    }

    public static void main(String[] args) {
//        Fib f = new Fib();
//        System.out.println(f.fib(100));
//        System.out.println(f.recursion(100));
//        System.out.println(longestValidParentheses("()(()"));
//        System.out.println(longestValidParentheses(")()())"));
//        System.out.println(longestValidParentheses("(((()))()()"));
//        System.out.println(longestValidParentheses(""));
        System.out.println(evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int longestValidParentheses(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }

        Stack<Integer> indexes = new Stack<>();
        char[] chrs = str.toCharArray();
        int l = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                indexes.push(i);
                continue;
            }

            if (chrs[i] == ')'){
                if (!indexes.isEmpty() && chrs[indexes.peek()] == '(') {
                    indexes.pop();
                    int tmp;
                    if (indexes.isEmpty()) {
                        tmp = i + 1;
                    } else {
                        tmp = i - indexes.peek();
                    }
                    if (l < tmp) {
                        l = tmp;
                    }
                } else {
                    indexes.push(i);
                }
            }
        }
        return l;
    }

    private final static List<String> signs = Arrays.asList("+", "-", "*", "/");
    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> st = new Stack<>();
        int j = 0, n = tokens.length;
        while (j < n) {
            if (!signs.contains(tokens[j])) {
                st.push(tokens[j]);
            } else {
                if (st.size() > 1) {
                    int e = Integer.valueOf(st.pop());
                    int s = Integer.valueOf(st.pop());
                    st.push(String.valueOf(eval(s, e, tokens[j])));
                }
            }
            j++;
        }
        return Integer.valueOf(st.pop());
    }

    public static int eval(int s, int e, String sign) {
        if ("+".equals(sign)) {
            return s + e;
        } else if ("-".equals(sign)) {
            return s - e;
        } else if ("*".equals(sign)) {
            return s * e;
        } else if ("/".equals(sign)) {
            return s / e;
        }
        return 0;
    }

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i < 3) {
                dp[i] = i;
                continue;
            }
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
