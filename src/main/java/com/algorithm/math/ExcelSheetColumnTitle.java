package com.algorithm.math;

import java.util.Stack;

public class ExcelSheetColumnTitle {
    final static char[] chrs = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * #168
     * https://leetcode-cn.com/problems/excel-sheet-column-title/
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(convertToTitle(1));
//        System.out.println(convertToTitle(2));
//        System.out.println(convertToTitle(3));
//        System.out.println(convertToTitle(4));
//        System.out.println(convertToTitle(26));
//        System.out.println(convertToTitle(27));
//        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(520));
    }

    public static String convertToTitle(int n) {
        if (n < 1) {
            return "";
        }
        Stack<Character> st = new Stack<>();
        while (n > 0) {
            int left = n % 26;
            if (left == 0) {
                st.push(chrs[25]);
                n = n / 26 - 1;
            } else {
                st.push(chrs[left - 1]);
                n = n / 26;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.toString();
    }
}
