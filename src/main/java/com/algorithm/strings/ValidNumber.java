package com.algorithm.strings;

public class ValidNumber {
    /**
     * #65
     * https://leetcode-cn.com/problems/valid-number
     *
     * @param args
     */
    public static void main(String[] args) {
        String s0 = "0"; // True
        String s1 = "3."; // True
        String s2 = " 0.1 "; // True
        String s3 = "abc"; // False
        String s4 = "1 a"; // False
        String s5 = ""; // True
        System.out.println(isNumber(s0));
        System.out.println(isNumber(s1));
        System.out.println(isNumber(s2));
        System.out.println(isNumber(s3));
        System.out.println(isNumber(s4));
        System.out.println(isNumber(s5));

        String s6 = "-e10"; // False
        String s7 = " 2e-9 "; // True
        String s8 = "+e1"; // False
        String s9 = "1+e"; // False
        String s10 = " "; // False
        System.out.println(isNumber(s6));
        System.out.println(isNumber(s7));
        System.out.println(isNumber(s8));
        System.out.println(isNumber(s9));
        System.out.println(isNumber(s10));

        String s11 = "e9"; // False
        String s12 = "4e+"; // False
        String s13 = " -."; // False
        String s14 = "+.8"; // True
        String s15 = " 005047e+6"; // True
        System.out.println(isNumber(s11));
        System.out.println(isNumber(s12));
        System.out.println(isNumber(s13));
        System.out.println(isNumber(s14));
        System.out.println(isNumber(s15));

        String s16 = ".e1"; // False
        String s17 = "3.e"; // False
        String s18 = "3.e1"; // True
        String s19 = "+1.e+5"; // True
        String s20 = " -54.53061"; // True
        System.out.println(isNumber(s16));
        System.out.println(isNumber(s17));
        System.out.println(isNumber(s18));
        System.out.println(isNumber(s19));
        System.out.println(isNumber(s20));

        String s21 = ". 1"; // False
        System.out.println(isNumber(s21));
        System.out.println(isNumber("e9"));
    }

    public static boolean isNumber(String s) {
        if (s == null || s.trim() == "") {
            return false;
        }
        int si = 0, ei = s.length() - 1;
        while (si <= ei && s.charAt(si) == ' ') {
            si++;
        }
        while (si <= ei && s.charAt(ei) == ' ') {
            ei--;
        }
        if (si <= ei && (s.charAt(si) == '+' || s.charAt(si) == '-')) {
            si++;
        }
        if (si > ei) {
            return false;
        }
        boolean digit = false, dot = false, exp = false;
        for (; si <= ei; si++) {
            if (Character.isDigit(s.charAt(si))) {
                digit = true;
            } else if (s.charAt(si) == 'E' || s.charAt(si) == 'e') {
                if (exp || !digit || si == ei) {
                    return false;
                }
                exp = true;
            } else if (s.charAt(si) == '.') {
                if (dot || exp || (!digit && si == ei)) {
                    return false;
                }
                dot = true;
            } else if (s.charAt(si) == '+' || s.charAt(si) == '-') {
                if (si == ei || (s.charAt(si - 1) != 'e' && s.charAt(si - 1) != 'E')) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
