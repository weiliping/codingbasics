package com.algorithm.contest.biweeklycontest52;

public class SortSentence {
    public static void main(String[] args) {
        SortSentence s = new SortSentence();
        System.out.println(s.sortSentence("is2 sentence4 This1 a3"));
        System.out.println(s.sortSentence("Myself2 Me1 I4 and3"));
    }

    public String sortSentence(String s) {
        String[] strs = s.split(" ");
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            while (Character.isDigit(strs[i].charAt(strs[i].length() - 1))) {
                int ind = strs[i].charAt(strs[i].length() - 1) - '1';
                if (ind == i) {
                    strs[i] = strs[i].substring(0, strs[i].length() - 1);
                    break;
                }
                String t = strs[i];
                strs[i] = strs[ind];
                strs[ind] = t.substring(0, t.length() - 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str).append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
