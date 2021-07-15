package com.algorithm.contest.weeklycontest238;

/**
 * https://leetcode-cn.com/problems/longest-substring-of-all-vowels-in-order/
 * #1839
 *
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * 子字符串 是字符串中一个连续的字符序列。
 *  
 * 示例 1：
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 *
 * 示例 2：
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 */
public class LongestBeautifulSubstring {
    public static void main(String[] args) {
        LongestBeautifulSubstring l = new LongestBeautifulSubstring();
        System.out.println(l.longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        System.out.println(l.longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));
        System.out.println(l.longestBeautifulSubstring("a"));
    }

    public int longestBeautifulSubstring(String word) {
        char[] chs = word.toCharArray();
        int n = chs.length, i = 0, j = 0, cnt = 0, res = 0;
        while (j < n) {
            if (j == 0 || chs[j - 1] < chs[j]) {
                cnt++;
                j++;
                continue;
            }
            if (chs[j - 1] == chs[j]) {
                j++;
                continue;
            }
            if (cnt == 5) {
                if (res < j - i) {
                    res = j - i;
                }
            }
            i = j;
            cnt = 1;
            j++;
        }
        if (cnt == 5) {
            if (res < j - i) {
                res = j - i;
            }
        }
        return res;
    }
}
