package com.algorithm.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class PermutationString {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(permutation("abc")));
    }

    public static String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[0];
        }

        HashSet<String> res = new HashSet<>();
        int n = s.length();
        dfs(0, s.toCharArray(), res, n);

        String[] strs = new String[res.size()];
        Iterator<String> it = res.iterator();
        int i = 0;
        while (it.hasNext()) {
            strs[i] = (String) it.next();
            i++;
        }
        return strs;
    }

    static void dfs(int s, char[] chars, HashSet<String> res, int len) {
        if (s + 1 == len) {
            StringBuilder sb = new StringBuilder().append(chars);
            res.add(sb.toString());
            return;
        }
        for (int i = s; i < len; i++) {
            swapChar(chars, i, s);
            dfs(s + 1, chars, res, len);
            swapChar(chars, s, i);
        }
    }

    static void swapChar(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
