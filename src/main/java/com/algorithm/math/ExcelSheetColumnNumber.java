package com.algorithm.math;

public class ExcelSheetColumnNumber {

    /**
     * #171
     * https://leetcode-cn.com/problems/excel-sheet-column-number/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }

    public static int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0, m = 1;
        for (int j = s.length() - 1; j >= 0; j--) {
            res += charToNumber(s.charAt(j)) * m;
            m *= 26;
        }
        return res;
    }

    static int charToNumber(char c) {
        return c - 'A' + 1;
    }
}
