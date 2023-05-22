package com.algorithm.others;

public class WildcardMatching {

    public static void main(String[] args) {
        WildcardMatching match = new WildcardMatching();
        //        String s = "aa", p = "a"; // false;
        //        String s = "aa", p = "*"; // true
        //        String s = "cb", p = "?a"; // false
        //        String s = "adceb", p = "*a*b"; // true
        //        String s = "acdcb", p = "a*c?b"; // false
        //        String s = "aa", p = "*";
        //        String s = "b", p = "?";
        //        String s = "mississippi", p = "m??*ss*?i*pi";
        //        String s="b", p="*?*?*";
        String s = "aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", p = "a*******b";
        System.out.println("[" + p + "] result = " + match.isMatch(s, p));
    }

    public boolean match(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (p.equals("*") || s.equals(p)) {
            return true;
        }

        if (s.isEmpty()) {
            return false;
        }

        if (p.charAt(0) == '?' || s.charAt(0) == p.charAt(0)) {
            return match(s, p);
        }

        if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
        }

        return false;
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        if (s.isEmpty()) {
            if (p.charAt(0) == '?') {
                return false;
            }
            if (p.charAt(0) == '*') {
                if (p.length() == 1 && p.charAt(0) == '*') {
                    return true;
                }
                if (p.length() > 1) {
                    return isMatch(s, p.substring(1));
                }
                return false;
            }
        }

        if (p.charAt(0) == '?' || (!s.isEmpty() && p.charAt(0) == s.charAt(0))) {
            return isMatch(s.substring(1), p.substring(1));
        }

        if (p.charAt(0) == '*') {
            return isMatch(s, p.substring(1)) || isMatch(s.substring(1), p);
        }
        return false;
    }
}
