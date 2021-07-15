package com.algorithm.twopointers;

import java.util.Stack;

public class BackspaceCompare {
    /**
     * #844
     * https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions/blob/master/2.%20Pattern%20Two%20Pointers/Problem%20Challenge%202%20-%20Comparing%20Strings%20containing%20Backspaces%20(medium).py
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(compare("xp#", "xyz##"));
        System.out.println(backspaceCompare("xp#", "xyz##"));
        System.out.println(backspaceCompareII("xp#", "xyz##"));
    }

    public static boolean compare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, cnt1 = 0, cnt2 = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0 && (S.charAt(i) == '#' || cnt1 > 0)) {
                if (S.charAt(i--) == '#') {
                    cnt1++;
                } else {
                    cnt1--;
                }
            }
            while (j >= 0 && (T.charAt(j) == '#' || cnt2 > 0)) {
                if (T.charAt(j--) == '#') {
                    cnt2++;
                } else {
                    cnt2--;
                }
            }
            if (i < 0 || j < 0) {
                return i == j;
            }

            if (S.charAt(i--) != T.charAt(j--)) {
                return false;
            }
        }
        return i == j;
    }

    public static boolean backspaceCompare(String str1, String str2) {
        return deleteBackspace(str1).equals(deleteBackspace(str2));
    }

    public static boolean backspaceCompareII(String str1, String str2) {
        return removeBackSpace(str1).equals(removeBackSpace(str2));
    }

    static String deleteBackspace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sb.length() != 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    static String removeBackSpace(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for (int i = chs.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(chs[i]);
                continue;
            }
            if (stack.peek() == '#') {
                if (chs[i] != '#') {
                    stack.pop();
                    continue;
                }
                stack.push(chs[i]);
                continue;
            }
            stack.push(chs[i]);
        }

        while (!stack.isEmpty() && stack.peek() == '#') {
            stack.pop();
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

    static String clean(String str) {
        int n = str.length(), i = n - 1;

        while (i >= 0) {
            int count = 0;
            while (i >= 0 && str.charAt(i) == '#') {
                count++;
                i--;
            }

            if (count > 0 && i + count == n - 1) {
                str = str.substring(0, i - count + 1);
                i -= count;
            } else if (count > 0 && i - count + 1 == 0) {
                str = str.substring(i + count + 1);
                i = -1;
            } else if (count > 0) {
                str = str.substring(0, i - count + 1) + str.substring(i + count + 1);
                i = i - count;
            } else {
                i--;
            }
        }
        return str;
    }
}
