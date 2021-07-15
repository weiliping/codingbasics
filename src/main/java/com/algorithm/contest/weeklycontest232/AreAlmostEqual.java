package com.algorithm.contest.weeklycontest232;

/**
 * https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal/
 * #1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 *
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 *
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 *
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 *
 */
public class AreAlmostEqual {
    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
        System.out.println(areAlmostEqual("abcd", "dcba"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        int start = -1, n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (start == n) {
                return false;
            }
            if (start == -1) {
                start = i;
            } else {
                if (s1.charAt(start) != s2.charAt(i) || s2.charAt(start) != s1.charAt(i)) {
                    return false;
                }
                start = n;
            }
        }
        return start == -1 || start == n;
    }
}
