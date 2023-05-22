package com.algorithm.contest.weeklycontest225;

public class ReplacingHiddenDigits {
    public static void main(String[] args) {
//        System.out.println(replaceHideDigit("2?:?0"));
//        System.out.println(replaceHideDigit("0?:3?"));
//        System.out.println(replaceHideDigit("1?:22"));
//        System.out.println(replaceHideDigit("?4:03"));
        System.out.println(replaceHideDigit("??:3?"));
    }

    static final int[][] digits = new int[][] { { 2, 1 }, { 9, 9, 3 }, {}, { 5 }, { 9 } };
    public static String replaceHideDigit(String time) {
        char[] chs = time.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ':') {
                continue;
            }
            if (chs[i] == '?') {
                if (i == 0 && (chs[i + 1] - '0' >= 4 && chs[i + 1] - '0' <= 9)) {
                    chs[i] = (char) ('0' + digits[i][1]);
                    continue;
                }
                if (i == 1) {
                    chs[i] = (char) ('0'+ digits[1][chs[i - 1] - '0']);
                    continue;
                }
                chs[i] = (char) ('0' + digits[i][0]);
            }
        }
        return new String(chs);
    }
}
