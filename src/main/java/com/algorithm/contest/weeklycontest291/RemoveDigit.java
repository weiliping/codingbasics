package com.algorithm.contest.weeklycontest291;

public class RemoveDigit {
    public static void main(String[] args) {
        System.out.println(removeDigit("1231", '1'));
    }

    public static String removeDigit(String number, char digit) {
        String s = "";
        int n = number.length();
        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                String sub = number.substring(0, i) + number.substring(i + 1);
                if (s.compareTo(sub) < 0) {
                    s = sub;
                }
            }
        }
        return s;
    }
}
