package com.algorithm.stacksandqueues;

import java.util.Stack;

public class Calculate {
    /**
     * #227
     * https://leetcode-cn.com/problems/basic-calculator-ii/
     *
     * @param args
     */
    public static void main(String[] args) {
        //        System.out.println(calculate("3+2*2"));
        //        System.out.println(calculate("42"));
        //        System.out.println(calculate("0-2147483647"));
        System.out.println(calculate("0-1+1"));
    }

    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int num = 0, n = s.length();
        char op = '+';
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (chs[i] >= '0') {
                num = num * 10 + chs[i] - '0';
            }
            if ((chs[i] < '0' && chs[i] != ' ') || i == n - 1) {
                if (op == '+')
                    st.push(num);
                if (op == '-')
                    st.push(-num);
                if (op == '*' || op == '/') {
                    int tmp = (op == '*') ? st.peek() * num : st.peek() / num;
                    st.pop();
                    st.push(tmp);
                }
                op = chs[i];
                num = 0;
            }
        }
        while (!st.empty()) {
            res += st.pop();
        }
        return res;
    }
}
