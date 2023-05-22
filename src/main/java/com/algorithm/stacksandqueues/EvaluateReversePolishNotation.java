package com.algorithm.stacksandqueues;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    /**
     * #150
     * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[] { "2", "1", "+", "3", "*" }));
        System.out.println(evalRPN(new String[] { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    public static int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> queue = new Stack<>();
        for (String token : tokens) {
            if (isNumber(token)) {
                queue.push(Integer.valueOf(token));
                continue;
            }
            if (queue.size() >= 2) {
                Integer num1 = queue.pop();
                Integer num2 = queue.pop();
                if ("+".equals(token)) {
                    queue.push(num2 + num1);
                }
                if ("-".equals(token)) {
                    queue.push(num2 - num1);
                }
                if ("*".equals(token)) {
                    queue.push(num2 * num1);
                }
                if ("/".equals(token)) {
                    queue.push(num2 / num1);
                }
            }
        }
        return queue.pop();
    }

    static boolean isNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            int ch = num.charAt(i);
            if (i == 0 && ch == '-' && num.length() > 1) {
                continue;
            }
            if ( ch > 57 || ch < 48){
                return false;
            }
        }
        return true;
    }
}
