package com.algorithm.contest.weeklycontest220;

public class ReformatNumber {
    public static void main(String[] args) {
        System.out.println(reformatNumber("1-23-45 6"));
        System.out.println(reformatNumber("123 4-567"));
        System.out.println(reformatNumber("123 4-5678"));
        System.out.println(reformatNumber("12"));
        System.out.println(reformatNumber("--17-5 229 35-39475 "));
    }
    public static String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        char[] chrs = number.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == ' ' || chrs[i] == '-') {
                continue;
            }
            sb.append(chrs[i]);
            cnt++;
            if (cnt == 3) {
                cnt = 0;
                sb.append('-');
            }
        }
        if (cnt == 0) {
            return sb.substring(0, sb.length() - 1);
        }
        if (cnt == 1) {
            int ind = sb.length() - 3;
            char ch = sb.charAt(ind);
            sb.deleteCharAt(ind).insert(ind + 1, ch);
        }
        return sb.toString();
    }
}
