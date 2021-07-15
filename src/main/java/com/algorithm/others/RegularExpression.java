package com.algorithm.others;

public class RegularExpression {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }

    public static void main(String[] args) {
        //        RegularExpression rg = new RegularExpression();
        //        System.out.println(rg.isMatch("aa", "a"));
        //        System.out.println(rg.isMatch("aa", ".*"));
        //        System.out.println(rg.isMatch("aaa", "a.*"));
        //        System.out.println(rg.isMatch("aaa", "a.*aa"));
        //        System.out.println(rg.isMatch("aaa", "a.*aaa"));
        //        System.out.println(rg.isMatch("aaa", "a.*a*a*a*aa"));
        //        System.out.println(rg.isMatch("aaa", "a.a"));
        //        System.out.println(rg.isMatch("aaa", "a*.a"));
        //        System.out.println(rg.isMatch("aa", "a*"));
        //        System.out.println(rg.isMatch("ab", ".*"));
        //        System.out.println(rg.isMatch("aab", "c*a*b"));
        //        System.out.println(rg.isMatch("aab", "c*d*d*a*b"));
        //        System.out.println(rg.isMatch("aabcc", "c*d*d*a*bc."));
        //        System.out.println(rg.isMatch("ppi", "p*."));
        int j = 0, i = 0, k = 0;

        while (true) {
            if (j < 5) {
                System.out.println("before j === " + ++i);
                System.out.println("j === " + k++);
            }
            j++;
            if (j >= 10) {
                break;
            }
        }
    }
}
