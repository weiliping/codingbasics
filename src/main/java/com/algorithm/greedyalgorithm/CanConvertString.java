package com.algorithm.greedyalgorithm;

public class CanConvertString {

    public static void main(String[] args) {
//        System.out.println(canConvertStringII("input", "ouput", 9));
//        System.out.println(canConvertStringII("abc", "bcd", 10));
        System.out.println(canConvertStringII("jicfxaa", "ocxltbp", 15));
    }

    public static boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        int x;
        for (int i = 0; i < s.length(); i++) {
            x = t.charAt(i) - s.charAt(i);
            if (x < 0) {
                x += 26;
            }
            a[x]++;
        }
        x = 0;
        int idx = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= x) {
                x = a[i];
                idx = i;
            }
        }
        return 26 * (x - 1) + idx <= k;
    }

    public static boolean canConvertStringII(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = t.charAt(i) - s.charAt(i);
            if (idx < 0) {
                idx += 26;
            }
            a[idx]++;
        }

        int x = 0;
        int indx = 0;

        for (int i = 1; i < 26; i++) {
            if (a[i] >= x) {
                x = a[i];
                indx = i;
            }
        }

        return (x - 1) * 26 + indx <= k;
    }
}
