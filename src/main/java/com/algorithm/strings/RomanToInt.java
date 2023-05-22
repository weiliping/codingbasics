package com.algorithm.strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    /**
     * #13
     * https://leetcode-cn.com/problems/roman-to-integer/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || values.get(s.charAt(i)) <= values.get(s.charAt(i - 1))) {
                res += values.get(s.charAt(i));
            } else {
                res += values.get(s.charAt(i)) - 2 * values.get(s.charAt(i - 1));
            }
        }
        return res;
    }
}
