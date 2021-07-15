package com.algorithm.strings;

public class ZigzagConversion {

    /**
     * #6
     * https://leetcode-cn.com/problems/zigzag-conversion/
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        int size = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < s.length(); j += size) {
                sb.append(s.charAt(j));
                int pos = j + size - 2 * i;
                if (i != 0 && i != numRows - 1 && pos < s.length()) {
                    sb.append(s.charAt(pos));
                }
            }
        }
        return sb.toString();
    }
}
