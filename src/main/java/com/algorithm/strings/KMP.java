package com.algorithm.strings;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        // "abddddddddd"
        System.out.println(Arrays.toString(calcPrefixLen("abcabcc")));
    }

    public static int[] calcPrefixLen(String pattern) {
        int patternLen = pattern.length();
        int[] ar = new int[patternLen + 1];
        ar[0] = -1;
        ar[1] = 0;
        int prefixLen = 0;
        int i = 1;

        while (i < patternLen) {
            if (pattern.charAt(prefixLen) == pattern.charAt(i)) {
                prefixLen++;
                i++;
                ar[i] = prefixLen;
            } else if (prefixLen > 0) {
                prefixLen = ar[prefixLen];
            } else {
                i++;
                ar[i] = 0;
            }
        }
        return ar;
    }
}
