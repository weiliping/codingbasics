package com.algorithm.contest.weeklycontest237;

/**
 * https://leetcode-cn.com/problems/check-if-the-sentence-is-pangram/
 * #1832. 判断句子是否为全字母句
 *
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * 如果是，返回 true ；否则，返回 false 。
 *  
 * 示例 1：
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 *
 */
public class CheckIfPangram {
    public static void main(String[] args) {
        CheckIfPangram c = new CheckIfPangram();
        System.out.println(c.checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

    public boolean checkIfPangram(String sentence) {
        boolean[] chrs = new boolean[26];
        int cnt = 0;
        char[] chs = sentence.toCharArray();
        for (char c : chs) {
            if (!chrs[c - 'a']) {
                cnt++;
                chrs[c - 'a'] = true;
                if (cnt == 26) {
                    return true;
                }
            }
        }
        return cnt == 26;
    }
}
