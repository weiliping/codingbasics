package com.algorithm.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(letterCasePermutation("a1b2").toArray()));
        System.out.println(Arrays.toString(letterPermutation("a1b2").toArray()));
    }

    public static List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null) {
            return res;
        }
        letterPermHelper(res, S.toCharArray(), 0);
        return res;
    }

    static void letterPermHelper(List<String> res, char[] chars, int s) {
        if (s == chars.length) {
            res.add(new String(chars));
            return;
        }
        if (chars[s] >= '0' && chars[s] <= '9') {
            letterPermHelper(res, chars, s + 1);
            return;
        }

        chars[s] =  Character.toUpperCase(chars[s]);
        letterPermHelper(res, chars, s + 1);

        chars[s] = Character.toLowerCase(chars[s]);
        letterPermHelper(res, chars, s + 1);
    }

    public static List<String> letterPermutation(String S) {
        return helper(S, S.length());
    }

    static List<String> helper(String str, int s) {
        if (s == 0) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> subRes = helper(str, s - 1);

        List<String> res = new ArrayList<>();
        char ch = str.charAt(s - 1);
        boolean isDigit = Character.isDigit(ch);
        for (String subStr : subRes) {
            if (!isDigit) {
                res.add(subStr + Character.toLowerCase(ch));
                res.add(subStr + Character.toUpperCase(ch));
                continue;
            }
            res.add(subStr + ch);
        }
        return res;
    }
}
