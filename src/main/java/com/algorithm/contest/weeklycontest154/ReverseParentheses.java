package com.algorithm.contest.weeklycontest154;

import java.util.ArrayDeque;

public class ReverseParentheses {
    public static void main(String[] args) {
        String s1 = "(abcd)";
        System.out.println(reverseParentheses(s1));
        String s2 = "(u(love)i)";
        System.out.println(reverseParentheses(s2));
        String s3 = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s3));
        String s4 = "a(bcdefghijkl(mno)p)q";
        String res = reverseParentheses(s4);
        System.out.println(res.equals("apmnolkjihgfedcbq"));
        String res2 = reverseParentheses("ta()usw((((a))))");
        System.out.println(res2);
    }

    public static String reverseParentheses(String s) {
        int n = s.length();
        char[] chrs = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (chrs[i] != ')') {
                stack.push(chrs[i]);
                continue;
            }

            while (!stack.isEmpty() && stack.peek() != '(') {
                queue.offer(stack.pop());
            }

            if (!stack.isEmpty()) {
                stack.pop();
            }

            while (!queue.isEmpty()) {
                stack.push(queue.poll());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
