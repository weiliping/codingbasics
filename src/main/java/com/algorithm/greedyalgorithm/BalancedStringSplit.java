package com.algorithm.greedyalgorithm;

import java.util.Stack;

public class BalancedStringSplit {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
        System.out.println(balancedStringSplit("LLLLRRRR"));
    }
    public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0, n = s.length();
        int res = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                res++;
            } else {
                Character c = stack.peek();
                if (c != ch) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            i++;
        }
        return res;
    }
}
