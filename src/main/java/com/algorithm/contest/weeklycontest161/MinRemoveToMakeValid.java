package com.algorithm.contest.weeklycontest161;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (chrs[i] == ')') {
                if (num > 0) {
                    num--;
                    continue;
                }
                chrs[i] = '-';
                continue;
            }
            if (chrs[i] == '(') {
                num++;
            }
        }
        num = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (chrs[i] == '(') {
                if (num > 0) {
                    num--;
                    continue;
                }
                chrs[i] = '-';
                continue;
            }
            if (chrs[i] == ')') {
                num++;
            }
        }
        for (char ch : chrs) {
            if (ch != '-') {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
