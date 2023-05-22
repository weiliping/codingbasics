package com.algorithm.others;

public class ZigzagConversionCopy {
    public static String convert(String s, int numRows) {
        if (s == null) {
            return null;
        }
        if (numRows < 2) {
            return s;
        }
        int strLen = s.length(), currRow = 0;
        int rowNum = strLen > numRows ? numRows : strLen;
        boolean godown = false;

        StringBuilder[] rows = new StringBuilder[rowNum];
        for (int i = 0; i < s.length(); i++) {
            if (rows[currRow] == null) {
                rows[currRow] = new StringBuilder();
            }
            rows[currRow].append(s.charAt(i));
            if (currRow == 0 || currRow == rowNum - 1) {
                godown = !godown;
            }
            currRow += godown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder sb : rows) {
            ret.append(sb);
        }
        return ret.toString();
    }

    public static void main(String[] args) {

        boolean flag = "LCIRETOESIIGEDHN".equals(convert("LEETCODEISHIRING", 3));
        //        LCIRETOESIIGEDHN
        System.out.println(flag);
        System.out.println(convert("LEETCODEISHIRING", 4));
        System.out.println(convert("LEETCODEISHIRING", 3));
    }
}
