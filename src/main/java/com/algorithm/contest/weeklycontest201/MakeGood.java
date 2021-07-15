package com.algorithm.contest.weeklycontest201;

public class MakeGood {

    public static void main(String[] args) {
//        System.out.println(new MakeGood().makeGood("leEeetcode"));
//        System.out.println(new MakeGood().makeGood("abBAcC"));
        System.out.println(new MakeGood().makeGood("Pp"));
    }
    public String makeGood(String s) {
        int i = 0, n = s.length();
        StringBuilder sb = new StringBuilder(s);
        while (i < n - 1) {
            char c = s.charAt(i);
            char c2 = s.charAt(i + 1);

            if ((Character.isLowerCase(c2) && c == Character.toUpperCase(c2)) ||
                    (Character.isUpperCase(c2) && c == Character.toLowerCase(c2))) {
                sb.deleteCharAt(i + 1);
                sb.deleteCharAt(i);
                s = sb.toString();
                n = s.length();
                i = 0;
                continue;
            }
            i++;
        }
        return sb.toString();
    }
}
