package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinations {

    /**
     * #17
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> res = new LetterCombinations().letterCombinations("235");
        System.out.println(Arrays.toString(res.toArray()));
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> res = new ArrayList<String>();
        if (digits.equals("")) {
            return res;
        }
        String[] keyboard = new String[] { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        letterCombinationsRe(keyboard, res, digits, "");
        return res;
    }

    public void letterCombinationsRe(String[] keyboard, ArrayList<String> res, String digits, String s) {
        if (s.length() == digits.length()) {
            res.add(s);
            return;
        }
        String letters = keyboard[digits.charAt(s.length()) - '0'];

        for (int i = 0; i < letters.length(); ++i) {
            letterCombinationsRe(keyboard, res, digits, s + letters.charAt(i));
        }
    }
}
