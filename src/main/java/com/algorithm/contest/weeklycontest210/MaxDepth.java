package com.algorithm.contest.weeklycontest210;

import java.util.ArrayDeque;

public class MaxDepth {
    public static void main(String[] args) {
        MaxDepth m = new MaxDepth();
        System.out.println(m.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(m.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(m.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(m.maxDepth("1"));
        System.out.println(m.maxDepth("8*((1*(5+6))*(8/6))"));
        System.out.println(m.maxDepthI("8*((1*(5+6))*(8/6))"));
    }
    public int maxDepthI(String s) {
        int cnt = 0, res = 0;
        char[] chrs = s.toCharArray();
        for (char c : chrs) {
            if (c == '(') {
                cnt++;
                if (res < cnt) {
                    res = cnt;
                }
                continue;
            }
            if (c == ')') {;
                cnt--;
            }
        }
        return res;
    }

    public int maxDepth(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] chrs = s.toCharArray();
        int cnt = 0;
        for (char c : chrs) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        if (cnt < 1) {
                            cnt = 1;
                        }
                        continue;
                    }
                    if (stack.peek() == '(') {
                        stack.push('1');
                    }
                    continue;
                }
                int depth = (stack.pop() - '0') + 1;
                stack.pop();
                if (stack.isEmpty()) {
                    if (cnt < depth) {
                        cnt = depth;
                    }
                    continue;
                }
                if (stack.peek() == '(') {
                    stack.push((char) (depth + '0'));
                    continue;
                }
                int subDepth = stack.pop() - '0';
                if (depth < subDepth) {
                    depth = subDepth;
                }
                stack.push((char) (depth + '0'));
            }
        }
        return cnt;
    }
}
